package cn.itsource.gouwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.itsource.gouwu.client")
public class ProductServiceApplication_8002 {
     public static void main(String[] args) {
         SpringApplication.run(ProductServiceApplication_8002.class);
     }
}
