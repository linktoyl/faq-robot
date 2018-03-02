package cn.vitco.sr.pkg.entity;

/**
 * Created by Sterling on 2018/1/31.
 */
public enum QAMode {

    welcome("进入模式","welcome"),
    reply("对答模式", "reply"),
    hot("热点模式","hot"),
    cue("线索列表模式","cue"),
    assess("评价模式","assess");

    private String msg;
    private String value;

    private QAMode(String msg, String value){
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
