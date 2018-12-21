package chencj.cc.rest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import chencj.cc.rest.rule.MyRule;

@SpringBootApplication
@EnableEurekaClient

@RibbonClient(name="CHENCJRESTPROVIDER",configuration= {MyRule.class})
public class Consumer_8000_Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_8000_Application.class, args);
	}
}
