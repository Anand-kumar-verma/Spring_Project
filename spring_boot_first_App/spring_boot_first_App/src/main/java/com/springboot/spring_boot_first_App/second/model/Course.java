package com.springboot.spring_boot_first_App.second.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	@ Column(name="course_n",nullable = false)
	private String courseName;

	@Column(name = "course_i",nullable = false)
	private String courseInstructor;


	public Course(Integer courseId, String courseName, String courseInstructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseInstructor = courseInstructor;
	}
	
	public Course() {
		super();
	}


	

	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseInstructor=" + courseInstructor
				+ "]";
	}
	
}
