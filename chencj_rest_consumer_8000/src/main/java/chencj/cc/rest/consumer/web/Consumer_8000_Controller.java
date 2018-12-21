package chencj.cc.rest.consumer.web;

import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import chencj.cc.rest.entity.Student;
import chencj.cc.rest.rule.MyRule;



@RestController

public class Consumer_8000_Controller {

	//public static final String REST_URI_PREFIX = "http://localhost:8001";
	public static final String REST_URI_PREFIX = "http://CHENCJRESTPROVIDER";
	@Autowired
	private RestTemplate restTemplate;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/consumer/stu/showList")
	public List<Student> showList(){
		return restTemplate.getForObject(REST_URI_PREFIX+"/stu/showList", List.class);
	}
	
	@RequestMapping("/consumer/stu/showOne/{id}")
	public Student showOne(@PathVariable long id){
		return restTemplate.getForObject(REST_URI_PREFIX+"/stu/showOne/"+id, Student.class);
	}
	
	@RequestMapping("/consmer/stu/save")
	public Boolean save(@RequestBody Student student) {
		try {
			restTemplate.postForLocation(REST_URI_PREFIX+"/stu/save", student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/consumer/stu/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URI_PREFIX+"/stu/discovery", Object.class);
	}
	
}
