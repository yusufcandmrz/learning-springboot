package com.yusufcandmrz.springboot.cruddemo;

import com.yusufcandmrz.springboot.cruddemo.dao.AppDAO;
import com.yusufcandmrz.springboot.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
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

            // createInstructorWithCourseList(appDAO);

            // getInstructorWithCourseListById(appDAO);

            // getCourseListByInstructorId(appDAO);

            // updateConstructor(appDAO);

            // getCourseById(appDAO);

            // updateCourse(appDAO);

            // deleteCourseById(appDAO);

            // createCourseWithReviewList(appDAO);

            // getCourseWithReviewListById(appDAO);

            // createCourseWithStudentList(appDAO);

            // getCourseWithStudentListById(appDAO);

            // updateStudent(appDAO);

            // getStudentWithCourseListById(appDAO);

            deleteStudentById(appDAO);
        };
    }

    private void deleteStudentById(AppDAO appDAO) {
        int studentId = 1;
        appDAO.deleteStudentById(studentId);
        System.out.println("Student deleted");
    }

    private void updateStudent(AppDAO appDAO) {
        int studentId = 1;
        Student student = appDAO.getStudentWithCourseListById(studentId);

        Course courseOne = new Course("Boxing");
        Course courseTwo = new Course("Kick-boxing");

        student.addCourse(courseOne);
        student.addCourse(courseTwo);

        appDAO.updateStudent(student);
    }

    private void getStudentWithCourseListById(AppDAO appDAO) {
        int studentId = 1;
        Student student = appDAO.getStudentWithCourseListById(studentId);
        System.out.println("Student informationg: " + student);
        System.out.println("CourseList: " + student.getCourseList());
    }

    private void getCourseWithStudentListById(AppDAO appDAO) {
        int courseId = 11;
        Course course = appDAO.getCourseWithStudentListById(courseId);
        System.out.println("Course information: " + course);
        System.out.println("StudentList: " + course.getStudentList());
    }

    private void createCourseWithStudentList(AppDAO appDAO) {
        Course course = new Course("Bodybuilding");
        Student studentOne = new Student("Seyfullah", "Gundogdu", "seyfullahgundogdu@example.com");
        Student studentTwo = new Student("Alperen", "Kildir", "alperenkildir@example.com");
        course.addStudent(studentOne);
        course.addStudent(studentTwo);
        appDAO.createCourse(course);
    }

    private void getCourseWithReviewListById(AppDAO appDAO) {
        int courseId = 15;
        Course course = appDAO.getCourseWithReviewListById(courseId);
        System.out.println("Course information: " + course);
        System.out.println("ReviewList: " + course.getReviewList());
    }

    private void createCourseWithReviewList(AppDAO appDAO) {
        Course course = new Course("How to be a good developer");
        course.addReview(new Review("What a course!!!"));
        course.addReview(new Review("It's a waste of time"));
        course.addReview(new Review("Thanks for the course"));
        appDAO.createCourse(course);
    }

    private void deleteCourseById(AppDAO appDAO) {
        int courseId = 15;
        appDAO.deleteCourseById(courseId);
        System.out.println("Course deleted");
    }

    private void updateCourse(AppDAO appDAO) {
        int courseId = 10;
        Course course = appDAO.getCourseById(courseId);
        course.setTitle("How to Debugging in Kotlin");
        appDAO.updateCourse(course);
        System.out.println("Course updated");
    }

    private void getCourseById(AppDAO appDAO) {
        int courseId = 10;
        Course course = appDAO.getCourseById(courseId);
        System.out.println("Course information: " + course);
    }

    private void updateConstructor(AppDAO appDAO) {
        int instructorId = 1;
        Instructor instructor = appDAO.getInstructorById(instructorId);
        instructor.setFirstName("Furkan");
        instructor.setLastName("Ocalan");
        appDAO.updateInstructor(instructor);
        System.out.println("Instructor updated");
    }

    private void getCourseListByInstructorId(AppDAO appDAO) {
        int instructorId = 1;
        Instructor instructor = appDAO.getInstructorById(instructorId);
        List<Course> courseList = appDAO.getCourseListByInstructorId(instructorId);
        instructor.setCourseList(courseList);
        System.out.println(instructor.getCourseList());
    }

    private void getInstructorWithCourseListById(AppDAO appDAO) {
        int instructorId = 1;
        Instructor instructor = appDAO.getInstructorById(instructorId);
        System.out.println("Instructor information: " + instructor);
    }

    private void createInstructorWithCourseList(AppDAO appDAO) {
        Instructor instructor = new Instructor("Tolunay", "Ozturk", "tolunayozturk@example.com");
        InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/tolunayozturk", "debugging code");
        Course courseOne = new Course("How to Debugging in Java");
        Course courseTwo = new Course("How to Debugging in JavaScript");
        instructor.setInstructorDetail(instructorDetail);
        instructor.addCourse(courseOne);
        instructor.addCourse(courseTwo);
        appDAO.createInstructor(instructor);
        System.out.println("Instructor created: " + instructor);
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

        appDAO.createInstructor(instructor);
        System.out.println("Instructor created: " + instructor);
    }
}
