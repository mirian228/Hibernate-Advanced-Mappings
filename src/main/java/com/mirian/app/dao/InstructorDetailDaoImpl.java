package com.mirian.app.dao;

import com.mirian.app.model.Instructor;
import com.mirian.app.model.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDetailDaoImpl implements InstructorDetailDao {

    private final EntityManager entityManager;

    @Autowired
    public InstructorDetailDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int instructorDetailId) {
        return entityManager.find(InstructorDetail.class, instructorDetailId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int instructorDetailId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, instructorDetailId);
        entityManager.remove(instructorDetail);
    }
}
