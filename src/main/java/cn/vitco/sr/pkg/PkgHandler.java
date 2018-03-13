package cn.vitco.sr.pkg;

import cn.vitco.sr.entity.QAssess;
import cn.vitco.sr.lucene.LuceneServer;
import cn.vitco.sr.mapper.FAQ_QAMapper;
import cn.vitco.sr.pkg.entity.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sterling on 2018/1/31.
 */
@Component
public class PkgHandler {
    @Autowired
    private LuceneServer luceneServer;
    @Autowired
    private FAQ_QAMapper faqQaMapper;


    public PkgHandler(){}


    public RespPkg handler(QAPkg pkg){
        RespPkg respPkg = new RespPkg(pkg);
        String instr = (String) pkg.getContent();
        if(instr != null && !instr.isEmpty()) {
            faqQaMapper.addInLog(instr);
        }
        String nf = faqQaMapper.getQASetting(QASettingKeys.NOT_FOUND.value());
        switch (pkg.getMode()){
            case welcome:
                String wel = faqQaMapper.getQASetting(QASettingKeys.WELCOME_TITLE.value());
                respPkg.setData(wel);
                break;
            case reply:
                RespAnswer ra = luceneServer.queryIndex(pkg.getContent().toString());
                if(ra!=null) {
                    respPkg.setData(ra);
                }else{
                    respPkg.setData(nf);
                }
                break;
            case hot:
                break;
            case cue:
                List<RespQuestion> res = luceneServer.queryQuestion(pkg.getContent().toString(),10);
                String tit = faqQaMapper.getQASetting(QASettingKeys.CUE_TITLE.value());
                String end = faqQaMapper.getQASetting(QASettingKeys.CUE_END.value());
                Map<String, Object> datas = new HashMap<>();
                datas.put("title", tit);
                datas.put("list", res);
                datas.put("end", end);
                if(res==null || res.size()<1){
                    datas.put("not_found", nf);
                }
                respPkg.setData(datas);
                break;
            case assess:
                String str  =pkg.getContent().toString();
                JSONObject jsonPkg = JSONObject.fromObject(str);
                String flag = jsonPkg.getString("flag");
                int qaid = jsonPkg.getInt("qa_id");
                faqQaMapper.addAssess(new QAssess(qaid, "", flag));
                if(flag.equals("Y")){
                    faqQaMapper.addAccess(""+qaid);
                }

                //System.out.println("Test111："+str);
                break;
        }

        return respPkg;
    }

}
