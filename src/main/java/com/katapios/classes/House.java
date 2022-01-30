package com.katapios.classes;

import com.katapios.interfaces.Door;
import com.katapios.interfaces.Material;
import com.katapios.interfaces.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

public class House {

    private Window window;
    private int height;

    @Autowired
    private Material wall;

    //private Collection<Door> doors;
    private Map<String, Door> doors;


    public House(Window window) {
        this.window = window;
    }

    public Material getWall() {
        return wall;
    }

    public void setWall(Material wall) {
        this.wall = wall;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

//    public Collection<Door> getDoors() {
//        return doors;
//    }
//
//    public void setDoors(Collection<Door> doors) {
//        this.doors = doors;
//    }


    public Map<String, Door> getDoors() {
        return doors;
    }

    public void setDoors(Map<String, Door> doors) {
        this.doors = doors;
    }

    public void openWindow() {
        window.open();
    }

    public void bildTheWall() {
        for (int i = 1; i <= getHeight(); i++) {
            System.out.printf("floor: %d ", i);
            getWall().cover();
        }
    }

    public void installTheDoors(){
//        for (Door door: doors) {
//            door.install();
//        }

        for (Map.Entry <String, Door> e : doors.entrySet()){
            System.out.printf("Key %s. ", e.getKey());
            e.getValue().install();
        }

    }

}
