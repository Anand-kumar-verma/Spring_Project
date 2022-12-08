package com.springboot.spring_boot_first_App.second.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.spring_boot_first_App.second.model.Course;
import com.springboot.spring_boot_first_App.second.repos.CourseRepository;


@Service 			/// this is must for services
public class CourseService {
	

 @Autowired
 private CourseRepository courseRepository;  // this is repository this is must for communicate with the databses:

	
	// this is constructor  --> this is must for add all courses:

	// public CourseService() {
	// 	allCourse.add(new Course(101,"Java","Java learn with Anand kumar verma !"));
	// 	allCourse.add(new Course(102,"C++","C++ learn with Anand kumar verma !"));
	// 	allCourse.add(new Course(103,"Python","Python learn with Anand kumar verma !"));
	// 	allCourse.add(new Course(104,"C#","C# learn with Anand kumar verma !"));
	// 	allCourse.add(new Course(105,"Ruby","Ruby learn with Anand kumar verma !"));
	// 	allCourse.add(new Course(106,"C","https://www.imdb.com/title/tt3089922/"));
	// }
	
	
	public List<Course> allCourse() {
		List<Course> ac = courseRepository.findAll(); // this is for get all data from data bases;
		return ac;
	}


	/////   AB HAM YHA PAR FUNCTION K ANADAR PARAMERTER ME KOI BHI ANNOTATION NA LGAYE TB BHI KOII DIKKAT NHI HOGI !
 //     public Course postCourse(@RequestBody Course course){
 //		allCourse.add(course);
 //		return course;
 //		
 //	}
	
	
	public String postCourse(Course course){  // like this
		// allCourse.add(course);
		courseRepository.save(course); // this is for save course in databases 
		return "Save changed successfully";
		
	}
	
	// here write a Optional for communicating databases:
	public Optional<Course> sigleCourse(@PathVariable("courseId") Integer courseId ) {
		// for(Course sr: allCourse) {
		// 	if(sr.getCourseId() == courseId)
		// 		return sr;
		// }

		Optional<Course> sr = courseRepository.findById(courseId);

		return sr;
	}
	
	
	
	public String updateCourse(@PathVariable("courseId") Integer courseId,@RequestBody Course updateData ) {
		// int i = -1 ;
		// for(Course sr: allCourse) {
		// 	i++;
		// 	if(sr.getCourseId() == courseId) {
		// 		allCourse.set(i,updateData);
		// 		return "OK";
		// 	}
				
		// }

		courseRepository.updateCourseById(updateData.getCourseName(),updateData.getCourseInstructor(),courseId);
		return "Updated";
	}
	
	
	public String deleteCourse(@PathVariable("courseId") Integer courseId) {
		// int i = -1 ;
		// for(Course sr: allCourse) {
		// 	i++;
		// 	if(sr.getCourseId() == courseId) {
		// 		allCourse.remove(i);
		// 		return "OK";
		// 	}
			
		// }

		courseRepository.deleteById(courseId);
		return "Course deleted";
	}

	public List<Course> findByCourseInst(String name){
		return courseRepository.findByCourseInstructor(name);
	}
	public List<Course> findByCourseContaining(String name){
		return courseRepository.findByCourseNameContaining(name);
	}

	

}