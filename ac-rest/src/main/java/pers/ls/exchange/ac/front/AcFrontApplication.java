package pers.ls.exchange.ac.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("pers.ls.exchange.ac.front.mapper")
@EnableScheduling
public class AcFrontApplication {
    public static void main(String[] args){
        SpringApplication.run(AcFrontApplication.class);
    }
}
