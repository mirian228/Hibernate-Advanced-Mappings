package com.mirian.app;

import com.mirian.app.dao.InstructorDao;
import com.mirian.app.dao.InstructorDetailDao;
import com.mirian.app.model.Instructor;
import com.mirian.app.model.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateAdvancedMappingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateAdvancedMappingsApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(InstructorDao instructorDao, InstructorDetailDao instructorDetailDao) {
        return runner -> {
            findInstructorDetail(instructorDetailDao);
        };
    }

    private void findInstructorDetail(InstructorDetailDao instructorDetailDao) {
        int theId = 2;
        System.out.println("Finding instructor detail id: " + theId);
        InstructorDetail tempInstructorDetail = instructorDetailDao.findInstructorDetailById(theId);
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

    }

    private void deleteInstructorById(InstructorDao instructorDao) {
        int theId = 1;
        System.out.println("Finding Instructor with id: " + theId);
        System.out.println("Removing Instrcutor....");
        instructorDao.deleteInstructor(theId);
        System.out.println("Instructor removed");
    }

    private void findInstructor(InstructorDao instructorDao) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = instructorDao.findInstructorById(theId);

        System.out.println("temp instructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(InstructorDao instructorDao) {
        // Create Instructor and Instructor detail
        Instructor tempInstructor = new Instructor("Mirian", "Surmanidze", "m.s@gmail.com");
        InstructorDetail tempnIstructorDetail = new InstructorDetail("http://youtube.com/it.garage", "hobby");
        // Set instructor details attached to this obbject
        tempInstructor.setInstructorDetail(tempnIstructorDetail);
        // Print instructor
        System.out.println("Saving instructor: " + tempInstructor);
        // Save instructor
        instructorDao.save(tempInstructor);

    }

}
