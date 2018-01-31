package cn.vitco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.vitco.sr.mapper")
public class FaqRobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaqRobotApplication.class, args);
	}
}
