package com.mirian.app.dao;

import com.mirian.app.model.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;


@Repository
public class InstructorDaoImpl implements InstructorDao {


    private final EntityManager entityManager;

    @Autowired
    public InstructorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int instructorId) {
        return entityManager.find(Instructor.class, instructorId);
    }

    @Override
    @Transactional
    public void deleteInstructor(int instructorId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        entityManager.remove(instructor);
    }
}
