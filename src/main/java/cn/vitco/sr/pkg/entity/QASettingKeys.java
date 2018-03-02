package cn.vitco.sr.pkg.entity;

/**
 * Created by Sterling on 2018/2/3.
 */
public enum QASettingKeys {
    WELCOME_TITLE("欢迎词","WELCOME_TITLE"),
    CUE_TITLE("列表模式标题", "CUE_TITLE"),
    CUE_END("列表模式结束语","CUE_END"),
    NOT_FOUND("未找到数据提示", "NOT_FOUND"),
    HOT_TITLE("热点类型","HOT_TITLE");

    private String msg;
    private String value;

    private QASettingKeys(String msg, String value){
        this.msg = msg;
        this.value = value;
    }

    public String msg() {
        return msg;
    }

    public String value() {
        return value;
    }
}
