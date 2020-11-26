package com.daily.verify.verify.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.daily.verify.verify.excel.easyexcel.listenner.ModelExcelListener;
import com.daily.verify.verify.excel.easyexcel.model.UserExcelModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excel")
/***
 * excel模板下载
 */
public class UserController {
    /**
     * 下载模板
     */
    @GetMapping("/downloadUser")
    public void downloadTemplate(HttpServletResponse response) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("easyexcel/user.xlsx");
        Workbook workbook;
        try {
            //xls格式
            InputStream inputStream = classPathResource.getInputStream();
            workbook = new HSSFWorkbook(inputStream);
        } catch (OfficeXmlFileException e) {
            //xlsx格式
            e.printStackTrace();
            InputStream inputStream = classPathResource.getInputStream();
            workbook = new XSSFWorkbook(inputStream);
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode("user.xlsx", "utf-8"));
        response.setHeader("Access-Control-Expose-Headers", "content-Disposition");
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 导出从数据
     */
    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();

        //构造标题头
        String[] columnNames = {"user_name", "user_age", "user_phone", "user_sex"};

        Sheet sheet = workbook.createSheet("param");
        Font titleFont = workbook.createFont();
        titleFont.setFontName("simsun");
        titleFont.setBold(true);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        titleStyle.setFont(titleFont);

        Row titleRow = sheet.createRow(0);

        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(titleStyle);
        }
        //模拟构造数据
        List<UserExcelModel> dataList = new ArrayList<>();
        dataList.add(new UserExcelModel("张三", 12, "13867098765", "男"));
        dataList.add(new UserExcelModel("张三1", 12, "13867098765", "男"));
        dataList.add(new UserExcelModel("张三2", 12, "13867098765", "男"));
        dataList.add(new UserExcelModel("张三3", 12, "13867098765", "男"));

        //创建数据行并写入值
        for (int j = 0; j < dataList.size(); j++) {
            UserExcelModel userExcelModel = dataList.get(j);
            int lastRowNum = sheet.getLastRowNum();
            Row dataRow = sheet.createRow(lastRowNum + 1);
            dataRow.createCell(0).setCellValue(userExcelModel.getName());
            dataRow.createCell(1).setCellValue(userExcelModel.getAge());
            dataRow.createCell(2).setCellValue(userExcelModel.getMobile());
            dataRow.createCell(3).setCellValue(userExcelModel.getSex());
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode("easyexcel.xls", "utf-8"));
        response.setHeader("Access-Control-Expose-Headers", "content-Disposition");
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 解析传入的excel文件
     *
     * @param file
     * @return
     */
    @PostMapping("/readExcel")
    public List<UserExcelModel> readExcel(@RequestParam("file") MultipartFile file) {
        List<UserExcelModel> list = new ArrayList<>();
        try {
            list = EasyExcel.read(file.getInputStream(), UserExcelModel.class, new ModelExcelListener()).sheet().doReadSync();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}