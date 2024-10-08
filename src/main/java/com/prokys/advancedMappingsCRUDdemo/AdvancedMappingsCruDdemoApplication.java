package com.prokys.advancedMappingsCRUDdemo;

import com.prokys.advancedMappingsCRUDdemo.dao.AppDAO;
import com.prokys.advancedMappingsCRUDdemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingsCruDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingsCruDdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
//			deleteCourseById(appDAO);
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
//			deleteCourseAndReviews(appDAO);
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourseById(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int id = 1;

		appDAO.deleteStudentById(1);

		System.out.println("Done");

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

		//create more courses
		Course tempCourse1 = new Course("Rubiks cube - How to speed cube");
		Course tempCourse2 = new Course("Atari 2600 - game development");

		//add courses to student
		tempStudent.addCourses(tempCourse1);
		tempStudent.addCourses(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("Associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Loaded Students: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done");

	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How to score million points");

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "doe@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "public@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving course: " + tempCourse);
		System.out.println("Associated students: "+tempCourse.getStudents());
		appDAO.saveCourse(tempCourse);

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course with id: " + theId);
		appDAO.deleteCourseById(theId);

		System.out.println("Done");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;

		//get the course and reviews
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		//print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done");

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		//create course
		Course tempCourse = new Course("Pacman - How to score one million points");

		//add reviews
		tempCourse.addReview(new Review("Great course ... loved it"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dump course, you are an idiot"));

		//save the course, and reviews with cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.saveCourse(tempCourse);

		System.out.println("Done");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course with id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");

	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		// find the course
		System.out.println("Finding course with id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course with id: " + theId);
		tempCourse.setTitle("Enjoying the little things");

		appDAO.updateCourse(tempCourse);

		System.out.println("Done");

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		//find instructor
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update instructor
		System.out.println("Updating instructor with id: " + theId);
		tempInstructor.setFirstName("TESTER");

		appDAO.updateInstructor(tempInstructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;

		//find the instructor
		System.out.println("Finding instructor with id: "+id);
		Instructor tempInstructor = appDAO.findInstructorWithCoursesByIdJoinedFetch(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: "+tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+id);
		List<Course> courses = appDAO.findCoursesByInstructor(id);

		// associate courses to instructor
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses"+ tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		//create instructor
		Instructor tempInstructor = new Instructor("Susan", "Public", "public@luv2code.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Video games");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create courses
		Course tempCourse1 = new Course("Air guitar - The ultimate guide");
		Course tempCourse2 = new Course("The pinball masterclass");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save instructor
		//this will also save courses because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting the instructor detail: " + theId);

		appDAO.deleteInstructorDetailByID(theId);
		System.out.println("Done");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId=2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Deleting Instructor with id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 3;

		System.out.println("Finding Instructor with id: " +theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetails: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		//create instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");

		 */

		//create instructor
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "patel@luv2code.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//this will also save instructor details because of CascadeType.ALL
		System.out.println("Saving instructor " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
