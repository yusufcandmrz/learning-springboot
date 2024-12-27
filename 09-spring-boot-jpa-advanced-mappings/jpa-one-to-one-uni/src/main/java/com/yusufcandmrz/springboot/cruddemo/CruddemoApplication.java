package com.yusufcandmrz.springboot.cruddemo;

import com.yusufcandmrz.springboot.cruddemo.dao.AppDAO;
import com.yusufcandmrz.springboot.cruddemo.entity.Instructor;
import com.yusufcandmrz.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@SpringBootApplication()
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		/* var instructor = new Instructor("Yusuf", "Demiroz", "yusufdmrz@example.com");
		var instructorDetail = new InstructorDetail("www.youtube.com/yusufdmrz", "writing code");
		instructor.setInstructorDetail(instructorDetail); */

		var instructor = new Instructor("Emre", "Ozbay", "emreozbay@example.com");
		var instructorDetail = new InstructorDetail("www.youtube.com/emreozbay", "reading code");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println(instructor);
		appDAO.save(instructor);
	}
}
