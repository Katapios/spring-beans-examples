package com.katapios.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Repository
@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;
	
	@Autowired
	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	@Transactional(readOnly=true) 
	public List<Course> findAll() {
		return Lists.newArrayList(courseRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Course findById(int id) {
		return courseRepository.findOne(id);
	}


	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public void delete(int id) {
		courseRepository.delete(id);
	}



}