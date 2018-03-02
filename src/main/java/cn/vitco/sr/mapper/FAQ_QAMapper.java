package cn.vitco.sr.mapper;

import cn.vitco.mybatis.entity.Page;
import cn.vitco.sr.entity.FAQ_SR_QA;
import cn.vitco.sr.entity.QAssess;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Streling(linktoyl@163.com)
 */
public interface FAQ_QAMapper {
    List<FAQ_SR_QA> getQAList(@Param("jc_dm") String jc_dm);

    List<FAQ_SR_QA> listPageQA(Page page);

    boolean updateQA(Map map);

    boolean addQA(Map map);

    String getQASetting(@Param("setting_key") String setting_key);

    void addAccess(@Param("qa_id") String qa_id);

    boolean addAssess(QAssess qAssess);

    void addInLog(@Param("instr")String instr);
}
