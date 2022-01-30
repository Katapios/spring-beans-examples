package com.katapios.classes.objectTypes;

import com.katapios.interfaces.Door;

public class WoodDoor implements Door {
    @Override
    public void install() {
        System.out.println("installing the wood door");
    }
}
