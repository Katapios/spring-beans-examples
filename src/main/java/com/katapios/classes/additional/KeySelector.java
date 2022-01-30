package com.katapios.classes.additional;

import com.katapios.classes.objectTypes.MetallicDoor;
import com.katapios.interfaces.Door;

public class KeySelector {

    public String getKey(Door door) {
        if (door.getClass().equals(MetallicDoor.class)) {
            return "a";
        } else {
            return "b";
        }
    }
}
