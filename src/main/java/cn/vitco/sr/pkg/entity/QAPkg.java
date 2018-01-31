package cn.vitco.sr.pkg.entity;

import cn.vitco.sr.pkg.exception.QAPkgFormatException;

import java.util.Map;

/**
 * Created by Sterling on 2018/1/31.
 */
public class QAPkg {
    private QAType type;
    private QAMode mode;
    private Object content;

    public QAPkg(){}


    public QAPkg(QAType type, QAMode mode, Object content) {
        this.type = type;
        this.mode = mode;
        this.content = content;
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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public static QAPkg format(Map<String,String> map) throws QAPkgFormatException{
        if(map==null || map.size()<3){
            throw new QAPkgFormatException("参数个数错误, 请仔细检查!");
        }
        QAPkg pkg = new QAPkg();

        try {
            QAType t = QAType.valueOf(map.get("type"));
            pkg.setType(t);
        } catch (IllegalArgumentException e) {
            throw new QAPkgFormatException("参数type错误, 请仔细检查!");
        }
        try {
            QAMode m = QAMode.valueOf(map.get("mode"));
            pkg.setMode(m);
        } catch (IllegalArgumentException e) {
            throw new QAPkgFormatException("参数mode错误, 请仔细检查!");
        }

        Object c = map.get("content");
        if(c == null)
            throw new QAPkgFormatException("参数content错误, 请仔细检查!");

        pkg.setContent(c);

        return pkg;
    }
}
