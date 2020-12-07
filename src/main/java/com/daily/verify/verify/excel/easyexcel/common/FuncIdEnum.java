package com.daily.verify.verify.excel.easyexcel.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuncIdEnum {
    TFZQ_330300("TFZQ", "330300", "C:\\Users\\86178\\Desktop\\excel\\测试.xls", "C:\\Users\\86178\\Desktop\\excel", "paramSheet", "expireSheet", "successSheet", "falseSheet"),
    TFZQ_330301("TFZQ", "330310", "C:\\Users\\86178\\Desktop\\excel\\测试.xls", "C:\\Users\\86178\\Desktop\\excel", "paramSheet", "expireSheet", "successSheet", "falseSheet"),
    DEMO("DEMO", "1", "C:\\Users\\86178\\Desktop\\excel\\user.xlsx", "C:\\Users\\86178\\Desktop\\excel", "paramSheet", "expireSheet", "successSheet", "falseSheet"),
    EXCEL_MOCKFILE("1", "1", "C:\\Users\\86178\\Desktop\\excel\\mock.xls", "C:\\Users\\86178\\Desktop\\excel", "mock", "", "", "");
    /**
     * 分组Id
     */
    private String groupId;
    /**
     * 功能Id
     */
    private String funcId;
    /**
     * excel文件读取路径
     */
    private String filePath;
    /**
     * 文件输出地址
     */
    private String fileDir;
    /**
     * 入参sheet名称
     */
    private String paramSheetName;
    /**
     * 预期sheet名称
     */
    private String expireSheetName;
    /**
     * 对比成功sheet名称
     */
    private String successSheetName;
    /**
     * 对比失败sheet名称
     */
    private String falseSheetName;

    /**
     * 根据fundId获取文件路径
     */
    public static String getFilePathByFundId(String fundId, String groupId) {
        for (FuncIdEnum c : FuncIdEnum.values()) {
            if (c.getFuncId().equals(fundId) && c.getGroupId().equals(groupId)) {
                return c.getFilePath();
            }
        }
        return null;
    }

    /**
     * 根据fundId获取文件路径
     */
    public static String getFileDirByFundId(String fundId, String groupId) {
        for (FuncIdEnum c : FuncIdEnum.values()) {
            if (c.getFuncId().equals(fundId) && c.getGroupId().equals(groupId)) {
                return c.getFileDir();
            }
        }
        return null;
    }


    /**
     * 根据fundId获取枚举对象
     */
    public static FuncIdEnum getEnumByFundId(String fundId, String groupId) {
        for (FuncIdEnum c : FuncIdEnum.values()) {
            if (c.getFuncId().equals(fundId) && c.getGroupId().equals(groupId)) {
                return c;
            }
        }
        return null;
    }
}