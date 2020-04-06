package pers.ls.exchange.ac.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("pers.ls.exchange.ac.front.mapper")
public class AcFrontApplication {
    public static void main(String[] args){
        SpringApplication.run(AcFrontApplication.class);
    }
}
