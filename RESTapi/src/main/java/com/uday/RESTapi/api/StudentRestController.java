package com.uday.RESTapi.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.RESTapi.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/uday")
public class StudentRestController {
	private List<Student> theStudents;
	//define endpoint for "/students" - return a list of students
	//define PostConstruct to load the student data... only once!
	@PostConstruct
	public void loadData() {
		theStudents=new ArrayList<>();
		Student s1=new Student("Uday","Surya");
		Student s2=new Student("Sita","Maha");
		Student s3=new Student("Akhila","Reddy");
		Student s4=new Student("Venkat","Reddy");
		theStudents.add(s1);
		theStudents.add(s2);
		theStudents.add(s3);
		theStudents.add(s4);
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	//define endpoint pr "/students/{studentId}" - return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return theStudents.get(studentId);
	}
	
	
}

