package com.katapios.classes.materials;

import com.katapios.interfaces.Material;
import org.springframework.stereotype.Component;

@Component("brickBean")
public class Brick implements Material {
    @Override
    public void cover() {
        System.out.println("putting the bricks");
    }
}
