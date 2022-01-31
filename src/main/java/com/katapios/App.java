package com.katapios;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.katapios.DAO.Course;
import com.katapios.DAO.CourseService;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseService courseDao = context.getBean("springJpaCourseService", CourseService.class);

//		Course spring = new Course();
//		spring.setTitle("Spring");
//		spring.setLength(40);
//		spring.setDescription("Spring framework");
//		courseDao.insert(spring);

//        Course foundedCourse = courseDao.findById(10);
//        foundedCourse.setTitle("New Course");
//        foundedCourse.setLength(10);
//        foundedCourse.setDescription("New framework");
//        courseDao.update(foundedCourse);

//        courseDao.delete(6);


//        for(Course c : courseDao.findAll())
//            System.out.println(c);

//        System.out.println(courseDao.findById(1));
//
        for(Course c : courseDao.findByTitle("Ja"))
            System.out.println(c);
    }
}
