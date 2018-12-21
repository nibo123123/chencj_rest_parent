package chencj.cc.rest.consumer.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chencj.cc.rest.consumer.service.StudentFeignService;
import chencj.cc.rest.entity.Student;








@RestController

public class Consumer_Feign_8000_Controller {

	//public static final String REST_URI_PREFIX = "http://localhost:8001";
//	public static final String REST_URI_PREFIX = "http://CHENCJRESTPROVIDER";

	
//	@Autowired
//	private RestTemplate restTemplate;
	
//应用到feign resttemplate换成studentfeignservice
	@Autowired
	private StudentFeignService studentFeignService;
	
	@RequestMapping("/consumer/stu/showList")
	public List<Student> showList(){
		//return restTemplate.getForObject(REST_URI_PREFIX+"/stu/showList", List.class);
		System.out.println("/consumer/stu/showList");
		return studentFeignService.showList();
	}
	
	@RequestMapping("/consumer/stu/showOne/{id}")
	public Student showOne(@PathVariable(value="id") Long id){
		//return restTemplate.getForObject(REST_URI_PREFIX+"/stu/showOne/"+id, Student.class);
		return studentFeignService.showOne(id);
	}
	
	@RequestMapping("/consmer/stu/save")
	public Boolean save(@RequestBody Student student) {
		try {
			//restTemplate.postForLocation(REST_URI_PREFIX+"/stu/save", student);
			studentFeignService.save(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/consumer/stu/discovery")
	public Object discovery(){
		//return restTemplate.getForObject(REST_URI_PREFIX+"/stu/discovery", Object.class);
		return null;
	}
	
}
