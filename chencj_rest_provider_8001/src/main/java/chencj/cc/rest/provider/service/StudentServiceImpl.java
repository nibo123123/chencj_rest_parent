package chencj.cc.rest.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chencj.cc.rest.entity.Student;
import chencj.cc.rest.provider.mapper.StudentMapper;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public List<Student> findAll() {
		
		return studentMapper.findAll();
	}

	@Override
	public Student findOne(long id) {
		return studentMapper.findOne(id);
	}

	@Override
	public void save(Student student) {
		studentMapper.save(student);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
