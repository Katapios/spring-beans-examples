package com.katapios.springexamples.IoC;

import java.util.ArrayList;
import java.util.List;

//@Component
public class PopMusic implements Music{
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Opa Gangnam Style");
        songs.add("This is Emergency");
        songs.add("Freestyler");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
