package cn.vitco.sr.service;

import cn.vitco.sr.api.AuthController;
import cn.vitco.sr.lucene.LuceneServer;
import cn.vitco.sr.mapper.FAQ_QAMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Sterling on 2018/2/8.
 */
@Component
public class FAQService {

    private static final Logger log = LoggerFactory.getLogger(FAQService.class);

    @Autowired
    private FAQ_QAMapper qaMapper;
    @Autowired
    private LuceneServer luceneServer;

    public void updateQA(Map<String, Object> map) throws Exception{
        if(qaMapper.updateQA(map))
            luceneServer.updateIndex((String)map.get("qa_id"), map, 2);
    }

    public void addQA(Map<String, Object> map) throws Exception{
        if(qaMapper.addQA(map)) {
            Long qa_id = (Long) map.get("qa_id");
            if (qa_id != null) {
                log.info("插入新的QA："+qa_id);
                luceneServer.updateIndex(qa_id.toString(), map, 0);
            }
        }
    }

}
