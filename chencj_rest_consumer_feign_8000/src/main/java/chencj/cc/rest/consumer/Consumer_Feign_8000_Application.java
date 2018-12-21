package chencj.cc.rest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication

@EnableEurekaClient
@EnableFeignClients(basePackages="chencj.cc.rest.consumer.service")
public class Consumer_Feign_8000_Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_Feign_8000_Application.class, args);
	}
}
