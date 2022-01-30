package com.katapios.classes.objectTypes;

import com.katapios.interfaces.Window;
import org.springframework.stereotype.Component;

@Component
public class WoodFrameWindow implements Window {

    public void open(){
        System.out.println("woodframe window is open");
    }
}
