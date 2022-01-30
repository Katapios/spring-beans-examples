package com.katapios.classes.objectTypes;

import com.katapios.interfaces.Door;

public class MetallicDoor implements Door {
    @Override
    public void install() {
        System.out.println("installing the metallic door");
    }
}
