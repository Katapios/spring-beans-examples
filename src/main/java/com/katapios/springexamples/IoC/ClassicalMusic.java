package com.katapios.springexamples.IoC;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("singleton")
public class ClassicalMusic implements Music{
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Hungarian Rhapsody");
        songs.add("Symphony no. 5");
        songs.add("Night on Bald Mountain");
    }

    @PostConstruct
    public void doMyInit(){
        System.out.println(">>>> Player object initialized\n");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("\n>>>> Player object destroyed");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
