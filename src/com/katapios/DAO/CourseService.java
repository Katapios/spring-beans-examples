package com.katapios.DAO;

import java.util.List;

public interface CourseService {
	List<Course> findAll();
	Course findById(int id);
	Course save(Course course);
	void delete(int id);
}
