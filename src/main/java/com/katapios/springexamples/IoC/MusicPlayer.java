package com.katapios.springexamples.IoC;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

//@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
    private PopMusic popMusic;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;


    //@Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, PopMusic popMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.popMusic = popMusic;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void playMusic(MusicGenre genre) {
        Random random = new Random();

        int randomNumber = random.nextInt(3);

        switch (genre){
            case CLASSICAL:
                System.out.println("Random classical song: " + classicalMusic.getSongs().get(randomNumber));
                break;
            case ROCK:
                System.out.println("Random rock song: " + rockMusic.getSongs().get(randomNumber));
                break;
            case POP:
                System.out.println("Random pop song: " + popMusic.getSongs().get(randomNumber));
                break;
            default:
        }

    }
}