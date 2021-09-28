package com.jit.oo1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.oo1.model.Student;
import com.jit.oo1.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired StudentRepository studentRepositoy;

	@Override
	public Student save(Student student) {
		return studentRepositoy.save(student);
	}

	@Override
	public Student fatchStudentById(Long id) {
		Optional<Student> student = studentRepositoy.findById(id.intValue());
		if(student.isPresent()) {
			return student.get();
		}
		return null;
	}

}
