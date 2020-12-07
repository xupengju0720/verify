package com.daily.verify.verify.excel.easyexcel.service;

import com.daily.verify.verify.excel.easyexcel.common.ApiResponse;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface BaseService<E, P> {
    File rule(String filePath);

    ApiResponse ExcelHandel(String funcId, String groupId, E e, P p);

    List<P> readParamExcel(File file, Class<P> tClass, String sheetName);

    List<E> readExpireExcel(File file, Class<E> tClass, String sheetName);

    List<E> readyData(List<P> pList);

    Map<String, List<Map<String, Object>>> compareExcel(List<E> listE, List<E> listD);

    void writeExcel(Map<String, List<Map<String, Object>>> resultMap, Workbook workbook, String fileType, String sheetName, int sheetIndex, E e);
}
