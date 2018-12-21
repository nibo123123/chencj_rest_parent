package chencj.cc.rest.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chencj.cc.rest.entity.Student;

//@FeignClient(value="CHENCJRESTPROVIDER")
@FeignClient(value="CHENCJRESTPROVIDER",fallbackFactory=HystrixFallbackServiceImpl.class)
public interface StudentFeignService {

	@RequestMapping(value="/stu/showList",method=RequestMethod.GET)
	public List<Student> showList();
	
	@RequestMapping(value="/stu/showOne/{id}",method=RequestMethod.GET)
	public Student showOne(@PathVariable(value="id") Long id);
	
	@RequestMapping(value="/stu/save",method=RequestMethod.POST)
	public void save(@RequestBody Student student);
}
