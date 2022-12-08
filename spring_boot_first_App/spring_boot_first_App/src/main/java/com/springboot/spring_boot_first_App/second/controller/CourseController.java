package com.springboot.spring_boot_first_App.second.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.spring_boot_first_App.second.model.Course;
import com.springboot.spring_boot_first_App.second.services.CourseService;

@RestController
public class CourseController {
	
//	private List<Course> allCourse = new ArrayList<>();
//	
//	// this is constructor  --> this is must for addd all courses:
//	public CourseController() {
//		allCourse.add(new Course(101,"Java","Java learn with Anand kumar verma !"));
//		allCourse.add(new Course(102,"C++","C++ learn with Anand kumar verma !"));
//		allCourse.add(new Course(103,"Python","Python learn with Anand kumar verma !"));
//		allCourse.add(new Course(104,"C#","C# learn with Anand kumar verma !"));
//		allCourse.add(new Course(105,"Ruby","Ruby learn with Anand kumar verma !"));
//		allCourse.add(new Course(106,"C","https://www.imdb.com/title/tt3089922/"));
//	}
	
	 
//	@GetMapping("/courses")
//	public Course allCourse() {
//		return new Course(101, "Java", "Java learn with Anand !");
//	}
	
	
	@Autowired
	private CourseService courseservice; // this is only for , not need to create object by new keyword again and again
	
	
	
	@GetMapping("/courses")
	public List<Course> allCourse() {
//		System.out.println(allCourse.get(0));
//		return allCourse;
		return courseservice.allCourse();
	}

	
	@PostMapping("/postcourses")
	public String postCourse(@RequestBody Course course){
//		allCourse.add(course);
//		return course;
		return courseservice.postCourse(course);
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Optional<Course> sigleCourse(@PathVariable("courseId") Integer courseId ) {
//		for(Course sr: allCourse) {
//			if(sr.getCourseId() == courseId)
//				return sr;
//		}
//		return new Course(000,"Not found","Not found");
		
		/////////////////////////  for Error 404    //////////////////
		try {
			return courseservice.sigleCourse(courseId);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		
		
	}


	// To find all course  which have same name
	@GetMapping("/course/instructor/{name}")
	public List<Course> findByCourseInst(@PathVariable("name") String courseInstructor){
		return courseservice.findByCourseInst(courseInstructor); 
	}

	@GetMapping("/course/coursecontaining/{name}")
	public List<Course> findByCourseName(@PathVariable("name") String courseInstructor){
		return courseservice.findByCourseContaining(courseInstructor);
	}
	
	@PutMapping("/courses/{courseId}")
	public String updateCourse(@PathVariable("courseId") Integer courseId,@RequestBody Course updateData ) {
//		int i = -1 ;
//		for(Course sr: allCourse) {
//			i++;
//			if(sr.getCourseId() == courseId) {
//				allCourse.set(i,updateData);
//				return "OK";
//			}
//				
//		}
//		return "Error found";
		
		return courseservice.updateCourse(courseId, updateData);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable("courseId") Integer courseId) {
//		int i = -1 ;
//		for(Course sr: allCourse) {
//			i++;
//			if(sr.getCourseId() == courseId) {
//				allCourse.remove(i);
//				return "OK";
//			}
//			
//		}
//		return "Error found";
//	}
		return courseservice.deleteCourse(courseId);
   }
}
