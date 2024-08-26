package com.prokys.advancedMappingsCRUDdemo.dao;

import com.prokys.advancedMappingsCRUDdemo.entity.Course;
import com.prokys.advancedMappingsCRUDdemo.entity.Instructor;
import com.prokys.advancedMappingsCRUDdemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailByID(int id);

    List<Course> findCoursesByInstructor(int id);

    Instructor findInstructorWithCoursesByIdJoinedFetch(int id);

}
