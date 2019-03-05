package cn.itsource.gouwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonServiceApplicaton_8003 {
    public static void main(String[] args) {
        SpringApplication.run(CommonServiceApplicaton_8003.class);
    }
}
