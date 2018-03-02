package cn.vitco.sr.entity;

/**
 * Created by Sterling on 2018/2/5.
 */
public class QAssess {
    private int qa_id;
    private String user_id;
    private String assess;
    private String in_key;

    public QAssess(int qa_id, String user_id, String assess) {
        this.qa_id = qa_id;
        this.user_id = user_id;
        this.assess = assess;
    }

    public int getQa_id() {
        return qa_id;
    }

    public void setQa_id(int qa_id) {
        this.qa_id = qa_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    public String getIn_key() {
        return in_key;
    }

    public void setIn_key(String in_key) {
        this.in_key = in_key;
    }
}
