package cn.vitco.sr.pkg.entity;

/**
 * Created by Sterling on 2018/2/3.
 */
public class RespAnswer {
    private String qa_id;
    private String answer;

    public RespAnswer(){

    }

    public RespAnswer(String qa_id, String answer) {
        this.qa_id = qa_id;
        this.answer = answer;
    }

    public String getQa_id() {
        return qa_id;
    }

    public void setQa_id(String qa_id) {
        this.qa_id = qa_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
