package com.katapios;

import com.katapios.classes.House;
import com.katapios.classes.additional.City;
import com.katapios.classes.builder.BuilderConfig;
import com.katapios.classes.objectTypes.MainWindow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BuilderConfig.class);

        House house = context.getBean(House.class);
        house.bildTheWall();
        house.openWindow();

        context.close();

    }
}
