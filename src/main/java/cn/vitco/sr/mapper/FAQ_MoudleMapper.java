package cn.vitco.sr.mapper;

import cn.vitco.sr.entity.FAQ_Buss;
import cn.vitco.sr.entity.FAQ_Jc;
import cn.vitco.sr.entity.FAQ_Moudle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FAQ 模块映射 接口
 * @author Streling(linktoyl@163.com)
 */
public interface FAQ_MoudleMapper {
    List<FAQ_Moudle> getAllMoudle();

    List<FAQ_Buss> getAllBuss(@Param("moudle_id") String moudle_id);

    List<FAQ_Jc> getAllJc(@Param("buss_id") String buss_id, @Param("jc_dm") String jc_dm);
}
