package com.katapios;

import com.katapios.classes.House;
import com.katapios.classes.additional.City;
import com.katapios.classes.objectTypes.MainWindow;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //House house = context.getBean("houseBean", House.class);
        House house = context.getBean(House.class);

//        City city = context.getBean("test", City.class);

//        System.out.println(city.getCity());
//        System.out.println(city.getName());

        house.bildTheWall();
//        house.installTheDoors();
        house.openWindow();
//        System.out.printf("House height : %d\n", house.getHeight());
//
//        MainWindow window = context.getBean(MainWindow.class);
//        window.showMainWindow();

        context.close();

    }
}
