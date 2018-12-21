package chencj.cc.rest.provider.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import chencj.cc.rest.entity.Student;
import chencj.cc.rest.provider.service.StudentService;

@RestController

public class ProviderController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DiscoveryClient client;
	
	
	@RequestMapping("/stu/showList")
	public List<Student> showList(){
		List<Student> list = studentService.findAll();
		return list;
	}
	@RequestMapping("/stu/showOne/{id}")
	@HystrixCommand(fallbackMethod="HystrixHandle")//处理程序出现异常的后续 
	public Student showOne(@PathVariable("id") long id) {
		Student student = studentService.findOne(id);
		
		if(student==null)throw new RuntimeException(); 
		
		return student;
	}
	
	
	public Student HystrixHandle(@PathVariable("id") long id) {
		return new Student().setId(id).setName("该id："+id+"没有对应的数据信息，null--@HystrixCommand")
				.setDb_status("没有对应的数据库");
	}
	
	
	@RequestMapping("/stu/saveStu")
	public void save(@RequestBody Student student) {
		studentService.save(student);
	}
	
	@Value("${spring.application.name}")
	private String name;
	@Value("${server.port}")
	private int port;
	
	@RequestMapping("/info")
	public String info() {
		return "注入到eureka的提供者是："+name+":"+port;
	}
	
	@RequestMapping("/stu/discovery")
	public Object discovery() {
		//发现eureka中所有的服务
		List<String> list = client.getServices();
		//以CHENCJ_REST_PROVIDER_8001的key找到所有的服务
		List<ServiceInstance> uniqueServiceInstancesList = client.getInstances("CHENCJ_REST_PROVIDER_8001");
		for (ServiceInstance serviceInstance : uniqueServiceInstancesList) {
			System.out.println(serviceInstance.getServiceId()+"\t"+
								serviceInstance.getHost()+"\t"+serviceInstance.getUri());
		}
		return client;
	}
	
}
