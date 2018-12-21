package chencj.cc.rest.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MyRule {

	@Bean
	public IRule myIRule() {
		return new MyRandomRule();
	}
}
