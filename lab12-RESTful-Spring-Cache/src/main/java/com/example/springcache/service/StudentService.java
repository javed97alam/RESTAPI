package com.example.springcache.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springcache.domain.Student;

@Service
public class StudentService {
	@Cacheable("student")
	public Student getStudentByID(String id) {
		try {
			Thread.sleep(1000*5);
			System.out.println("Going to sleep for 5 Secs; id : "+id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Student(id,"Rushi" ,"Hyderabad");
		
	}
}
