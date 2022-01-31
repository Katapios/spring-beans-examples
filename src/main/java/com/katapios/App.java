package com.katapios;

import com.katapios.DAO.Course;
import com.katapios.DAO.CourseDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseDAO courseDao = context.getBean("jpaCourseService",CourseDAO.class);


//		Course spring = new Course();
//		spring.setTitle("Spring");
//		spring.setLength(40);
//		spring.setDescription("Spring framework");
//		courseDao.insert(spring);

//        Course foundedCourse = courseDao.findById(3);
//        foundedCourse.setTitle("New Course");
//        foundedCourse.setLength(10);
//        foundedCourse.setDescription("New framework");
//        courseDao.update(foundedCourse);

        //courseDao.delete(4);


        for(Course c : courseDao.findAll())
        	System.out.println(c);

//        System.out.println(courseDao.findById(2));
//
//        for(Course c : courseDao.findByTitle("Java course"))
//            System.out.println(c);

        context.close();
    }
}
