package com.katapios.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service("springJpaCourseService")
@Repository
@Transactional
public class SpringJpaCourseService implements CourseService {
    private static final Log LOG = LogFactory.getLog(SpringJpaCourseService.class);

    @Autowired
    private CourseRepository courseRepository;

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }



    @Transactional(readOnly=true)
    public List<Course> findAll() {
        return new ArrayList<Course>(courseRepository.findAll());
    }

    @Override
    public void insert(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findOne(id);
    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseRepository.findAll()
                .stream()
                .filter(t -> t.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }


}