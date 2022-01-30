package com.katapios.classes.materials;

import com.katapios.interfaces.Material;
import org.springframework.stereotype.Component;

@Component("woodBean")
public class Wood implements Material {
    @Override
    public void cover() {
        System.out.println("putting the wood");
    }
}
