package cn.vitco;

import cn.vitco.sr.api.AuthController;
import cn.vitco.sr.config.LuceneConfig;
import cn.vitco.sr.entity.FAQ_SR_QA;
import cn.vitco.sr.lucene.LuceneServer;
import cn.vitco.sr.mapper.FAQ_QAMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

@SpringBootApplication
@MapperScan("cn.vitco.sr.mapper")
public class FaqRobotApplication implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);


	@Autowired
	private LuceneConfig luceneConfig;
	@Autowired
	private LuceneServer luceneServer;
	@Autowired
	private FAQ_QAMapper faq_qaMapper;

	public static void main(String[] args) {
		SpringApplication.run(FaqRobotApplication.class, args);
	}

	public void onApplicationEvent(ContextRefreshedEvent event){

		if(LuceneConfig.getRunMode().equals("reload")) {
			log.info("启动后执行: 加载Lucene索引.");
			List<FAQ_SR_QA> list = faq_qaMapper.getQAList("");
			luceneServer.createIndex(list);
		}else{
			log.info("启动后执行: Lucene索引已经存在.");
		}
	}
}
