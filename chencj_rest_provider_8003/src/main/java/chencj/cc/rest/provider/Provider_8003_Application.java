package chencj.cc.rest.provider;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableDiscoveryClient
public class Provider_8003_Application {
	public static void main(String[] args) {
		SpringApplication.run(Provider_8003_Application.class, args);
	}
}
