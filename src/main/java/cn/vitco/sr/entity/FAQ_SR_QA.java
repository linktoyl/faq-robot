package cn.vitco.sr.entity;

/**
 * Created by Sterling on 2018/1/29.
 */
public class FAQ_SR_QA {
    private String qa_id;
    private String jc_dm;
    private String key_s;
    private String question;
    private String answer;
    private int access_count;
    private int weight;
    private String bz;

    public String getQa_id() {
        return qa_id;
    }

    public void setQa_id(String qa_id) {
        this.qa_id = qa_id;
    }

    public String getJc_dm() {
        return jc_dm;
    }

    public void setJc_dm(String jc_dm) {
        this.jc_dm = jc_dm;
    }

    public String getKey_s() {
        return key_s;
    }

    public void setKey_s(String key_s) {
        this.key_s = key_s;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getAccess_count() {
        return access_count;
    }

    public void setAccess_count(int access_count) {
        this.access_count = access_count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
