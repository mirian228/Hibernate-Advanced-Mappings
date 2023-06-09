package com.mirian.app.dao;

import com.mirian.app.model.Instructor;

public interface InstructorDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int instructorId);


    void deleteInstructor(int instructorId);
}
