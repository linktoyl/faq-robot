package cn.vitco.sr.pkg;

import cn.vitco.sr.lucene.LuceneServer;
import cn.vitco.sr.pkg.entity.QAPkg;
import cn.vitco.sr.pkg.entity.RespPkg;
import cn.vitco.sr.pkg.entity.RespQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sterling on 2018/1/31.
 */
@Component
public class PkgHandler {
    @Autowired
    private LuceneServer luceneServer;


    public PkgHandler(){}


    public RespPkg handler(QAPkg pkg){
        RespPkg respPkg = new RespPkg(pkg);
        switch (pkg.getMode()){
            case reply:
                String str = luceneServer.queryIndex(pkg.getContent().toString());
                respPkg.setData(str);
                break;
            case hot:
                break;
            case cue:
                List<RespQuestion> res = luceneServer.queryQuestion(pkg.getContent().toString(),6);
                respPkg.setData(res);
                break;
            case assess:
                break;
        }

        return respPkg;
    }

}
