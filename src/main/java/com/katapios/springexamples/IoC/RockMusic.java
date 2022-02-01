package com.katapios.springexamples.IoC;

import java.util.ArrayList;
import java.util.List;

//@Component
public class RockMusic implements Music{
    private List<String> songs = new ArrayList<>();

    {
        songs.add("The wind of change");
        songs.add("Californication");
        songs.add("Bloody roots");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
