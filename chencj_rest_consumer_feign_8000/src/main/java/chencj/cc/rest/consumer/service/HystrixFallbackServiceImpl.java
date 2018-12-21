package chencj.cc.rest.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import chencj.cc.rest.entity.Student;
import feign.hystrix.FallbackFactory;


/*
 * 不用在每个Controller层的方法上调用@HystrixCommand(fallbackMethod="HystrixHandle")//处理程序出现异常的后续 
 * 使用服务降级处理机制  降到服务层实现fallback
 * 通过匿名内部类实现异常兜底工作   aop思想实现
 * 
 * 
 * */
@Service
public class HystrixFallbackServiceImpl implements FallbackFactory<StudentFeignService>{

	@Override
	public StudentFeignService create(Throwable cause) {
		
		return new StudentFeignService() {
			
			@Override
			public Student showOne(Long id) {
				return new Student().setId(id).setName("该id："+id+"没有对应的数据信息，null--@HystrixCommand")
						.setDb_status("没有对应的数据库或者已经关闭");
			}
			
			@Override
			public List<Student> showList() {
				ArrayList<Student> list = new ArrayList<>();
				list.add(new Student().setName("没有对应的数据信息，null--@HystrixCommand")
						.setDb_status("没有对应的数据库"));
				return list;
			}
			
			@Override
			public void save(Student student) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
