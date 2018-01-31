package cn.vitco.sr.pkg.entity;

import java.io.Serializable;

/**
 * Created by Sterling on 2018/1/31.
 */
public class RespQuestion implements Serializable{
    private String qa_id;
    private String question;

    public RespQuestion(String qa_id, String question) {
        this.qa_id = qa_id;
        this.question = question;
    }

    public String getQa_id() {

        return qa_id;
    }

    public void setQa_id(String qa_id) {
        this.qa_id = qa_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
