package chencj.cc.rest.provider;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("chencj.cc.rest.consumer.service")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class Provider_Hystrix_8001_Application {
	public static void main(String[] args) {
		SpringApplication.run(Provider_Hystrix_8001_Application.class, args);
	}
}
