package com.springboot.spring_boot_first_App.second.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.spring_boot_first_App.second.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{    // Model class name and type of the primary key
    
    List<Course> findByCourseInstructor(String courseInstructor); /// this is for fetching data of same type in course Instructor:

    List<Course> findByCourseNameContaining(String courseName);

    @Transactional
    @Modifying
    @Query("update Course c set c.courseName= ?1, c.courseInstructor = ?2 where c.courseId=?3")
    void updateCourseById(String courseName,String courseInst,Integer courseId);
}
