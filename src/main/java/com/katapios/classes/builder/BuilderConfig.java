package com.katapios.classes.builder;

import com.katapios.classes.House;
import com.katapios.classes.materials.Brick;
import com.katapios.classes.objectTypes.WoodFrameWindow;
import com.katapios.interfaces.Window;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BuilderConfig {

    @Bean("wall")
    @Scope("prototype")
    public Brick bricks() {
        return new Brick();
    }

    @Bean
    public Window woodFrameWindow(){
        return new WoodFrameWindow();
    }

    @Bean
    public House house(){
        House house = new House(woodFrameWindow());
        house.setHeight(4);
        return house;
    }
}
