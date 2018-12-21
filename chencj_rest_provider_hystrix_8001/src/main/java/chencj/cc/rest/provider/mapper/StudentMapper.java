package chencj.cc.rest.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import chencj.cc.rest.entity.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();
	Student findOne(long id);
	void save(Student student);
	void delete(long id);
}
