package com.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class CruddemoApplicationTests {

	@Autowired
	StudentRepository studentRepo;

	@Test
	void saveStudent() {

		Student student = new Student();

		student.setName("Ram");
		student.setCity("Bengaluru");
		student.setFee(20000);
		studentRepo.save(student);
	}

	@Test
	void deleteStudent() {

		studentRepo.deleteById(4L);

	}

	@Test
	void updateStudent() {

		Student student = new Student();

		student.setId(1);
		student.setName("Chandan D S");
		student.setCity("Mandya");
		student.setFee(10000);
		studentRepo.save(student);

	}
	
	@Test
	 void readStudent() {
		
		List<Student> all = studentRepo.findAll();
		
		for(Student record:all) {
			System.out.println(record.getId());
			System.out.println(record.getName());
			System.out.println(record.getCity());
			System.out.println(record.getFee());
		}
		
	}
	    @Test
	  void findStudentById() {
	    	
	    	   Optional<Student> byId = studentRepo.findById(6L);
	    	   
	    	   Student student = byId.get();
	    	   
	    	   System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getCity());
				System.out.println(student.getFee());		  
	  }

}
