package com.mirian.app.dao;

import com.mirian.app.model.Instructor;
import com.mirian.app.model.InstructorDetail;

public interface InstructorDetailDao {

    void save(Instructor theInstructor);

    InstructorDetail findInstructorDetailById(int instructorId);


    void deleteInstructorDetail(int instructorId);
}
