package com.prokys.advancedMappingsCRUDdemo;

import com.prokys.advancedMappingsCRUDdemo.dao.AppDAO;
import com.prokys.advancedMappingsCRUDdemo.entity.Course;
import com.prokys.advancedMappingsCRUDdemo.entity.Instructor;
import com.prokys.advancedMappingsCRUDdemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.Lifecycle;
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
			findCoursesForInstructor(appDAO);
		};
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
		int theId = 2;

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
