package cn.vitco.sr.mapper;

import cn.vitco.sr.entity.FAQ_SR_QA;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Streling(linktoyl@163.com)
 */
public interface FAQ_QAMapper {
    List<FAQ_SR_QA> getQAList(@Param("jc_dm") String jc_dm);

    boolean updateQA(Map map);

    boolean addQA(Map map);
}
