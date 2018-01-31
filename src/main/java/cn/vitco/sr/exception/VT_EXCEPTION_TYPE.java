package cn.vitco.sr.exception;

/**
 * Created by Sterling on 2018/1/31.
 */
public enum VT_EXCEPTION_TYPE {
    LOGIC("[逻辑异常]"), BUSINESS("[业务异常]"), DATA("[数据异常]"), SYSTEM("[系统异常]");

    private String description;

    private VT_EXCEPTION_TYPE(String desc){
        this.description = desc;
    }

    public String toString() {
        return description;
    }
}
