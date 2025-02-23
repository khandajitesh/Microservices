package com.jit.oo1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jit.oo1.model.Student;
import com.jit.oo1.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}

	@RequestMapping(value = "student", method = RequestMethod.GET)
	public ResponseEntity<Student> fatchStudentById(@RequestParam Long id) {
		Student student = studentService.fatchStudentById(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(student);
		}

	}

}
