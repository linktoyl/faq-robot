package cn.vitco.sr.pkg.entity;

/**
 * Created by Sterling on 2018/1/31.
 */
public enum QAType {

    text("文本类型", "text"),
    image("图片类型","image"),
    audio("音频类型","audio");

    private String msg;
    private String value;

    private QAType(String msg, String value){
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

