package com.daily.verify.verify.excel.easyexcel.service;

import com.daily.verify.verify.excel.easyexcel.common.ApiResponse;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface BaseService<E, P> {
    /**
     *判断文件是否存在并且获取问价
     */
    File rule(String filePath);

    /**
     *主要流程方法
     */
    ApiResponse excelHandel(String funcId, String groupId, E e, P p);
    /**
     *读取excel的参数Sheet
     */
    List<P> readParamExcel(File file, Class<P> tClass, String sheetName);
    /**
     *读取excel的预期值
     */
    List<E> readExpireExcel(File file, Class<E> tClass, String sheetName);
    /**
     *使用参数值 来准备对比值 由各自的实例自己实现
     */
    List<E> readyData(List<P> pList);
    /**
     *进行数据对比
     */
    Map<String, List<Map<String, Object>>> compareExcel(List<E> listE, List<E> listD);
    /**
     *对比结果写入excel并输出 兼容xls额xlsx
     */
    void writeExcel(Map<String, List<Map<String, Object>>> resultMap, Workbook workbook, String fileType, String sheetName, int sheetIndex, E e);
}
