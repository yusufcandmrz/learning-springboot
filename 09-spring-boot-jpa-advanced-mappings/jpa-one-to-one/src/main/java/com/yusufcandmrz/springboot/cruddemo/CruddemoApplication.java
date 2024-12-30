package com.yusufcandmrz.springboot.cruddemo;

import com.yusufcandmrz.springboot.cruddemo.dao.AppDAO;
import com.yusufcandmrz.springboot.cruddemo.entity.Instructor;
import com.yusufcandmrz.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication()
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);

			// getInstructorById(appDAO);

			// deleteInstructorById(appDAO);

			// getInstructorDetailById(appDAO);

			// deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {

		int instructorDetailId = 4;
		appDAO.deleteInstructorDetailById(instructorDetailId);
		System.out.println("InstructorDetail deleted");
	}

	private void getInstructorDetailById(AppDAO appDAO) {

		int instructorDetailId = 3;
		InstructorDetail instructorDetail = appDAO.getInstructorDetailById(instructorDetailId);
		System.out.println("InstructorDetail information: " + instructorDetail);
		System.out.println("Instructor information: " + instructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {

		int instructorId = 1;
		appDAO.deleteInstructorById(instructorId);
		System.out.println("Instructor deleted");
	}

	private void getInstructorById(AppDAO appDAO) {

		int instructorId = 1;
		Instructor instructor = appDAO.getInstructorById(instructorId);
		System.out.println("Instructor information: " + instructor);
	}

	private void createInstructor(AppDAO appDAO) {

		var instructor = new Instructor("Yusuf", "Demiroz", "yusufdmrz@example.com");
		var instructorDetail = new InstructorDetail("www.youtube.com/yusufdmrz", "writing code");
		instructor.setInstructorDetail(instructorDetail);

		/* var instructor = new Instructor("Emre", "Ozbay", "emreozbay@example.com");
		var instructorDetail = new InstructorDetail("www.youtube.com/emreozbay", "reading code");
		instructor.setInstructorDetail(instructorDetail); */

		System.out.println(instructor);
		appDAO.createInstructor(instructor);
	}
}
