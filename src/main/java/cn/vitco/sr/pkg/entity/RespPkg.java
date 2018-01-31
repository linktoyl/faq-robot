package cn.vitco.sr.pkg.entity;

/**
 * Created by Sterling on 2018/1/31.
 */
public class RespPkg {
    private QAType type;
    private QAMode mode;
    private Object data;

    public RespPkg(){}

    public RespPkg(QAPkg pkg){
        this.type = pkg.getType();
        this.mode = pkg.getMode();
    }

    public RespPkg(QAType type, QAMode mode) {
        this.type = type;
        this.mode = mode;
    }

    public QAType getType() {
        return type;
    }

    public void setType(QAType type) {
        this.type = type;
    }

    public QAMode getMode() {
        return mode;
    }

    public void setMode(QAMode mode) {
        this.mode = mode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
