package com.riya.cruddemo;

import com.riya.cruddemo.dao.StudentDAO;
import com.riya.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numROwsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted Row Count: "+numROwsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6;
		System.out.println("Deleting student id : "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id : primary key
		int studentId = 1;
		System.out.println("Getting student with id : "+studentId);
		Student myStudent= studentDAO.findById(studentId);

		//change firstName to "John"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		//update the Student
		studentDAO.update(myStudent);

		//display the updated Student
		System.out.println("Updated Student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}

		//display list of students
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of Students
		List<Student> theStudents=studentDAO.findAll();

		//display the list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a Student Object
		System.out.println("Creating new Student Object ...");
		Student tempStudent = new Student("Daffy","Duck","daffy@wissen.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved Student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		//retrieve the student based on the id: primary key
		System.out.println("Retrieving the student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: "+ myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 Student Objects ...");
		Student tempStudent1 = new Student("John","Doe","john@wissen.com");
		Student tempStudent2 = new Student("Mary","Public","mary@wissen.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@wissen.com");


		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new Student Object ...");
		Student tempStudent = new Student("Paul","Doe","paul@wissen.com");

		//save the student object
		System.out.println("Saving the Student Object ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId() );
	}

}
