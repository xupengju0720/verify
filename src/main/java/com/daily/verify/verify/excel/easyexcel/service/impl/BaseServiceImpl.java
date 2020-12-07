package com.daily.verify.verify.excel.easyexcel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.daily.verify.verify.excel.easyexcel.anotation.ColumnField;
import com.daily.verify.verify.excel.easyexcel.anotation.CompareKey;
import com.daily.verify.verify.excel.easyexcel.common.ApiResponse;
import com.daily.verify.verify.excel.easyexcel.common.ErrorEnum;
import com.daily.verify.verify.excel.easyexcel.common.FuncIdEnum;
import com.daily.verify.verify.excel.easyexcel.listenner.ModelExcelListener;
import com.daily.verify.verify.excel.easyexcel.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@Getter
public abstract class BaseServiceImpl<E extends CompareKey, P> implements BaseService<E, P> {

    @Override
    public File rule(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            String originalFilename = file.getName();
            if (!StringUtils.endsWithIgnoreCase(originalFilename, "XLS") && !StringUtils.endsWithIgnoreCase(originalFilename, "XLSX")) {
                log.error("格式错误");
                return null;
            } else {
                return file;
            }
        }
        return null;
    }

    @Override
    public ApiResponse ExcelHandel(String funcId, String groupId, E e, P p) {
        Long start = System.currentTimeMillis();
        FuncIdEnum funcIdEnum = FuncIdEnum.getEnumByFundId(funcId, groupId);
        if (null == funcIdEnum)
            return new ApiResponse(ErrorEnum.E_498);
        File file = rule(funcIdEnum.getFilePath());
        if (null == file)
            return new ApiResponse(ErrorEnum.E_499);
        try {
            List<P> listParam = readParamExcel(file, (Class<P>) p.getClass(), funcIdEnum.getParamSheetName());
            log.info("读取参数Sheet完成");
            List<E> listExpire = readExpireExcel(file, (Class<E>) e.getClass(), funcIdEnum.getExpireSheetName());
            log.info("读取预期Sheet完成");
            List<E> listDb = readyData(listParam);
            //数据比对
            Map<String, List<Map<String, Object>>> resultMap = compareExcel(listExpire, listDb);
            log.info("数据对比完成");
            //对比成功结果
            Map<String, List<Map<String, Object>>> resultSuccessMap = sortResultMap(resultMap, "true");
            //对比失败结果
            Map<String, List<Map<String, Object>>> resultFalseMap = sortResultMap(resultMap, "false");
            log.info("对比结果分类完成");
            Workbook workbook;
            //格式兼容
            try {
                workbook = new HSSFWorkbook(new FileInputStream(file));
                //按照对应格式写入比对之后的结果
                writeExcel(resultFalseMap, workbook, "XLS", funcIdEnum.getFalseSheetName(), 0, listExpire.get(0));
                writeExcel(resultSuccessMap, workbook, "XLS", funcIdEnum.getSuccessSheetName(), 1, listExpire.get(0));
            } catch (OfficeXmlFileException err) {
                log.warn("文件格式错误:{}", err.getMessage());
                workbook = new XSSFWorkbook(new FileInputStream(file));
                writeExcel(resultFalseMap, workbook, "XLSX", funcIdEnum.getFalseSheetName(), 0, listExpire.get(0));
                writeExcel(resultSuccessMap, workbook, "XLSX", funcIdEnum.getSuccessSheetName(), 1, listExpire.get(0));
            }
            String fileOutPath = FuncIdEnum.getFileDirByFundId(funcId, groupId) + "\\" + new Date().getTime() + file.getName();
            File fileOut = new File(fileOutPath);
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(fileOut);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            Long end = System.currentTimeMillis();
            log.info("操作完成耗时:{}", end - start);
            return new ApiResponse(ErrorEnum.E_200);
        } catch (IOException exception) {

            log.error("错误内容:{}", exception.getMessage());
            exception.printStackTrace();
            return new ApiResponse().FalseApiResponse("400", exception.getMessage());
        }

    }


    @Override
    public List<P> readParamExcel(File file, Class<P> tClass, String sheetName) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<P> listExpire = EasyExcel.read(inputStream, tClass, new ModelExcelListener()).sheet(sheetName).doReadSync();
        return listExpire;
    }

    @Override
    public List<E> readExpireExcel(File file, Class<E> tClass, String sheetName) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<E> listExpire = EasyExcel.read(inputStream, tClass, new ModelExcelListener()).sheet(sheetName).doReadSync();
        return listExpire;
    }

    @Override
    public List<E> readyData(List<P> ps) {
        return null;
    }

    @Override
    public Map<String, List<Map<String, Object>>> compareExcel(List<E> listE, List<E> ListD) {
        Map<String, List<Map<String, Object>>> result = new HashMap<>();
        listE.forEach(x -> {
                    Map<String, Object> xMap = turnValueToMap(x);
                    String key = x.getCompareKey();
                    List<E> filterList = ListD.stream().filter(y -> {
                        return key.equals(y.getCompareKey());
                    }).collect(Collectors.toList());
                    if (CollectionUtils.isEmpty(filterList)) {
                        xMap.put("data_type", "测试输入预期值");
                        xMap.put("compare_result", "失败");
                        xMap.put("msg", "找不到比对数据");
                        List<Map<String, Object>> nullResult = new ArrayList<>();
                        nullResult.add(createCompareResult(xMap));
                        //没有找到的结果 造一条空的比对数据
                        Map<String, Object> expireMap = new HashMap<>();
                        expireMap.put("data_type", "测试输入预期值");
                        expireMap.put("compare_result", "失败");
                        expireMap.put("msg", "找不到比对数据");
                        nullResult.add(createCompareResult(expireMap));
                        result.put(key + "_false", nullResult);
                    } else {
                        //正常情况这里应该有两条数据 一条为测试输入  一条为da输出
                        Map<String, Object> comParemodel = comPareModel(xMap, turnValueToMap(filterList.get(0)));
                        String if_success = (String) comParemodel.get("success");
                        List<Map<String, Object>> comPareResultList = (List<Map<String, Object>>) comParemodel.get("value");
                        result.put(key + if_success, comPareResultList);
                    }
                }
        );
        return result;
    }

    //对比结果写入
    @Override
    public void writeExcel(Map<String, List<Map<String, Object>>> resultMap, Workbook workbook, String fileType, String sheetName, int sheetIndex, E e) {
        //获取添加注解的字段以及注解信息
        List<ColumnField> listColumns = getColumnField(e);
        Sheet sheet = workbook.createSheet(sheetName);
        workbook.setSheetOrder(sheetName, sheetIndex);
        Font titleFont = workbook.createFont();
        //表头颜色
        titleFont.setColor(IndexedColors.BLACK.index);
        CellStyle titleStyle = null;
        if (fileType.equals("XLS"))
            titleStyle = (HSSFCellStyle) workbook.createCellStyle();
        if (fileType.equals("XLSX"))
            titleStyle = (XSSFCellStyle) workbook.createCellStyle();

        Row titleRow = sheet.createRow(0);
        for (int i = 0; i < listColumns.size(); i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(listColumns.get(i).getValue());
            cell.setCellStyle(titleStyle);
        }
        //对比结果根据key排序
        List<String> ll = new ArrayList<>(resultMap.keySet());
        Collections.sort(ll);
        for (String key : ll) {
            //拿到一组数据 正常情况先 第一条为预期值 第二条为结果值
            List<Map<String, Object>> oneCompareResult = resultMap.get(key);
            oneCompareResult.forEach(x -> {
                int lastRowNum = sheet.getLastRowNum();
                Row dataRow = sheet.createRow(lastRowNum + 1);
                //这理的x为一整行数据 key为字段名 obj为该字段的比较结果
                Map<String, Object> mapLine = x;
                //为了保证表格内容与表头顺序一致 这里使用和表头一致的顺序 通过字段名称对应
                for (int i = 0; i < listColumns.size(); i++) {
                    String column = listColumns.get(i).getName();
                    for (String s : x.keySet()) {
                        //todo
                        Map<String, Object> map = (Map<String, Object>) x.get(s);
                        if (column.equals(map.get("column"))) {
                            Cell cell = dataRow.createCell(i);
                            Object object = map.get("value");
                            if (null != object)
                                cell.setCellValue(object.toString());
                            boolean ifsame = (boolean) map.get("result");
                            //给cell设置格式
                            CellStyle cellStyle = workbook.createCellStyle();
                            Font font = workbook.createFont();
                            //必须设置此格式 否则背景填充无效果
                            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                            if (0 == i || (listColumns.size() > 1 && listColumns.size() - 1 == i) || (1 == i)) {
                                //给首列和末尾两列添加黑色字体 黄色背景
                                cellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
                            } else if (!ifsame) {
                                //给错误的字段设置黑色字体 红色背景
                                cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                            }
                            cellStyle.setFont(font);
                            cell.setCellStyle(cellStyle);
                        }
                    }
                }
            });
        }
    }


    //进行数据比对
    private Map<String, Object> comPareModel(Map<String, Object> expireParam, Map<String, Object> dbParam) {
        Map<String, Object> result = new HashMap<>();
        //对象的每个字段对比结果记录
        List<Map<String, Object>> resultList = new ArrayList<>();
        //记录是否通过
        boolean ifTrue = true;
        //如果失败记录失败原因
        StringBuilder msg = new StringBuilder("");
        dbParam.put("data_type", "da输出实际值");
        dbParam.put("specialCode", expireParam.get("specialCode"));
        expireParam.put("data_type", "测试输入预期值");
        List<String> listKey = new ArrayList<>(dbParam.keySet());
        Map<String, Object> dbCompareMap = new HashMap<>();
        for (int i = 0; i < listKey.size(); i++) {
            Map<String, Object> compareMap = new HashMap<>();
            try {
                Object valuex = dbParam.get(listKey.get(i));
                Object valuee = expireParam.get(listKey.get(i));
                //使用map 这里的index顺序已经不可用
                //compareMap.put("index", i);
                compareMap.put("value", valuex);
                compareMap.put("column", listKey.get(i));
                if (judgeTwoObject(valuex, valuee)) {
                    compareMap.put("result", true);
                } else {
                    compareMap.put("result", false);
                    if (!"msg".equals(listKey.get(i)) && !"compare_result".equals(listKey.get(i)) && !"data_type".equals(listKey.get(i))) {
                        msg.append(listKey.get(i) + "/");
                        ifTrue = false;
                    }
                }
                dbCompareMap.put(listKey.get(i), compareMap);
            } catch (Exception e) {
                log.error("错误内容:{}", e.getMessage());
                ifTrue = false;
                e.printStackTrace();
            }
        }
        if (ifTrue) {
            expireParam.put("compare_result", "成功");
        } else {
            expireParam.put("compare_result", "失败");
            expireParam.put("msg", String.format("匹配失败:{%s}", msg.toString()));
        }
        resultList.add(createCompareResult(expireParam));
        resultList.add(dbCompareMap);

        //添加逻辑 给数据比对结果标识成功失败
        if (ifTrue) {
            result.put("success", "_true");
        } else {
            result.put("success", "_false");
        }
        result.put("value", resultList);
        return result;
    }

    //对数据库中没有的数据构造返回参数
    public static Map<String, Object> createCompareResult(Map<String, Object> mapParam) {
        Map<String, Object> result = new HashMap<>();
        List<String> listKey = new ArrayList<>(mapParam.keySet());
        for (int i = 0; i < listKey.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("column", listKey.get(i));
            map.put("value", mapParam.get(listKey.get(i)));
            map.put("result", true);
            result.put(listKey.get(i), map);
        }
        return result;
    }

    //将对象中有注释的转为Map
    private Map<String, Object> turnValueToMap(Object o) {
        Map<String, Object> result = new HashMap<>();
        try {
            Field[] fields = Arrays.asList(o.getClass().getDeclaredFields()).stream().filter((field) -> {
                return field.isAnnotationPresent(ExcelProperty.class);
            }).collect(Collectors.toList()).toArray(new Field[0]);
            for (Field field : fields) {
                field.setAccessible(true);
                result.put(field.getName(), field.get(o));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断两个字符串是否相等  默认"" 和 null是相等的
     */
    private boolean judgeTwoObject(Object valuex, Object valuee) {
        boolean result = true;
        if (!StringUtils.isEmpty(valuex) && StringUtils.isEmpty(valuee))
            result = false;
        if (StringUtils.isEmpty(valuex) && !StringUtils.isEmpty(valuee))
            result = false;
        if (!StringUtils.isEmpty(valuex) && !StringUtils.isEmpty(valuee) && !valuex.equals(valuee))
            result = false;
        return result;
    }


    //获取表头和此段值
    private List<ColumnField> getColumnField(E e) {
        List<Field> list = Arrays.asList(e.getClass().getDeclaredFields()).stream().filter((field) -> {
            return field.isAnnotationPresent(ExcelProperty.class);
        }).collect(Collectors.toList());
        List<ColumnField> lists = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Field field = list.get(i);
            ExcelProperty dc = field.getAnnotation(ExcelProperty.class);
            lists.add(new ColumnField(field.getName(), dc.value()[0], i));
        }
        return lists;
    }

    /**
     * 筛选出 对应的目的结果
     *
     * @param resultMap 目标集
     * @param aTrue     key值后缀
     * @return 结果集
     */
    private Map<String, List<Map<String, Object>>> sortResultMap
    (Map<String, List<Map<String, Object>>> resultMap, String aTrue) {
        Map<String, List<Map<String, Object>>> result = new HashMap<>();
        for (String key : resultMap.keySet()) {
            if (key.endsWith(aTrue)) {
                result.put(key, resultMap.get(key));
            }
        }
        return result;
    }

}
