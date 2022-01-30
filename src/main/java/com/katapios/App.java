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

        CourseDAO courseDAO = context.getBean(CourseDAO.class);

        System.out.println(courseDAO.findById(1).getTitle());

        for (Course c : courseDAO.findAll())
            System.out.println(c);

        context.close();
    }
}
