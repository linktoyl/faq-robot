package cn.vitco.sr.lucene;

import cn.vitco.sr.api.AuthController;
import cn.vitco.sr.config.LuceneConfig;
import cn.vitco.sr.entity.FAQ_SR_QA;
import cn.vitco.sr.pkg.entity.RespQuestion;
import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * lucene索引加载器
 *
 * Created by Sterling on 2018/1/31.
 */
@Component
public class LuceneServer {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private String indexPath = "../lidx/data";
    private String runMode;

    //创建directory(字典)和(Analyzer)分词器
    //1.创建Directory
    //索引存放目录
    //private String indexPath = "G:/luceneIndex";
    Directory dir;
    //也可以存放到内存
    //Directory  directory = new RAMDirectory();
    //2.创建分词器
    Analyzer analyzer;

    public LuceneServer() throws IOException {
        dir = FSDirectory.open(Paths.get(indexPath));
        analyzer = new ComplexAnalyzer();
    }

    public void createIndex(List<FAQ_SR_QA> ltpcs){

        IndexWriterConfig iwconfig = new IndexWriterConfig(analyzer);
        iwconfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter iw = null;

        try{
            iw = new IndexWriter(dir, iwconfig);
            for (FAQ_SR_QA tpc:ltpcs) {
                Document doc = new Document();
                doc.add(new TextField("qa_id", tpc.getQa_id(), Field.Store.YES));
                doc.add(new TextField("keyword", tpc.getKey_s(), Field.Store.YES));
                doc.add(new TextField("question", tpc.getQuestion(), Field.Store.YES));
                doc.add(new TextField("answer", tpc.getAnswer(), Field.Store.YES));
                //iw.addDocument(doc);
                iw.updateDocument(new Term("question", tpc.getQuestion()), doc);
            }
            iw.commit();
            iw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<RespQuestion> queryQuestion(String querykey, int cnt){
        List<RespQuestion> list = new ArrayList<RespQuestion>();
        try {
            IndexReader ir = DirectoryReader.open(dir);
            // 搜索器
            IndexSearcher searcher = new IndexSearcher(ir);
            // 查询哪个字段
            QueryParser parse = new QueryParser("question", analyzer);
            // 查询关键字
            Query query = parse.parse(querykey);
            TopDocs topDocs = searcher.search(query, cnt);

            // 碰撞结果
            ScoreDoc[] hits = topDocs.scoreDocs;

            if(hits!=null && hits.length>0){
                for (int i=0; i<hits.length; i++) {
                    Document hitDoc = searcher.doc(hits[i].doc);
                    list.add(new RespQuestion(hitDoc.get("qa_id"), hitDoc.get("question")));
                }
            }
            /*for (int i = 0; i < hits.length; i++) {
                ScoreDoc hit = hits[i];
                Document hitDoc = searcher.doc(hit.doc);
                // 结果按照得分来排序。主要由 关键字的个数和权值来决定
                System.out.println("(" + hit.doc + "-" + hit.score + ")" +
                        " keyword:" + hitDoc.get("keyword") +
                        " question:" + hitDoc.get("question") +
                        " answer:" + hitDoc.get("answer"));
            }*/
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String queryIndex(String querykey) {
        String result = "未找到结果!";
        try {
            IndexReader ir = DirectoryReader.open(dir);
            // 搜索器
            IndexSearcher searcher = new IndexSearcher(ir);
            // 查询哪个字段
            QueryParser parse = new QueryParser("question", analyzer);
            // 查询关键字
            Query query = parse.parse(querykey);
            TopDocs topDocs = searcher.search(query, 1000);

            // 碰撞结果
            ScoreDoc[] hits = topDocs.scoreDocs;
            System.out.println("匹配个数:" +hits.length);
            if(hits!=null && hits.length>0){
                Document hitDoc = searcher.doc(hits[0].doc);
                result = hitDoc.get("answer");
            }
            /*for (int i = 0; i < hits.length; i++) {
                ScoreDoc hit = hits[i];
                Document hitDoc = searcher.doc(hit.doc);
                // 结果按照得分来排序。主要由 关键字的个数和权值来决定
                System.out.println("(" + hit.doc + "-" + hit.score + ")" +
                        " keyword:" + hitDoc.get("keyword") +
                        " question:" + hitDoc.get("question") +
                        " answer:" + hitDoc.get("answer"));
            }*/
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
