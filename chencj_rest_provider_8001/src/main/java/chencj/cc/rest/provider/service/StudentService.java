package chencj.cc.rest.provider.service;

import java.util.List;

import chencj.cc.rest.entity.Student;

public interface StudentService {
	List<Student> findAll();
	Student findOne(long id);
	void save(Student student);
	void delete(long id);
}
