package com.prokys.advancedMappingsCRUDdemo.dao;

import com.prokys.advancedMappingsCRUDdemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

}
