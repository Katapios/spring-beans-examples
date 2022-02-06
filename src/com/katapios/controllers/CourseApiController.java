package com.katapios.controllers;

import com.katapios.DAO.Course;
import com.katapios.DAO.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/course")
public class CourseApiController {
    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Course> list(){
        return courseService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Course findById(@PathVariable int id){
        return courseService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Course create(@RequestBody Course course){
        return courseService.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Course update(@RequestBody Course course, @PathVariable int id){
        course.setId(id);
        return courseService.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void  delete(@PathVariable int id){
        courseService.delete(id);
    }
}
