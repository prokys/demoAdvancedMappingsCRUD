package com.prokys.advancedMappingsCRUDdemo;

import com.prokys.advancedMappingsCRUDdemo.dao.AppDAO;
import com.prokys.advancedMappingsCRUDdemo.entity.Instructor;
import com.prokys.advancedMappingsCRUDdemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingsCruDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingsCruDdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
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
