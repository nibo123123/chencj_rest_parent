package chencj.cc.rest.zuul;

import javax.swing.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul9014Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul9014Application.class, args);
	}
}
