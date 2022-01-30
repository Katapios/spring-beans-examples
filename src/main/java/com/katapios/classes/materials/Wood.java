package com.katapios.classes.materials;

import com.katapios.interfaces.Material;

public class Wood implements Material {
    @Override
    public void cover() {
        System.out.println("putting the wood");
    }
}
