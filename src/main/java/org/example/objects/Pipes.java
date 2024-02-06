package org.example.objects;

import org.example.Main;
import org.example.sound.Sound;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Pipes {
    private List<Pipe> pipes;
    private Random random;
    private long timeMilli;
    private int base = Main.HEIGHT - 60;
    private int built = 0;
    private int score = 0;

    private Sound sound;
    public Pipes() {
        pipes = new ArrayList<>();
        random = new Random();
        initTubes();
        sound = new Sound();
        sound.setFile(0);
    }

    private void initTubes() {

        Date date = new Date();
        timeMilli = date.getTime() + 2000;

        int last = base;
        int randWay = random.nextInt(10);

        for (int i = 0; i < 20; i++) {

            Pipe tempPipe = new Pipe(800, last);
            tempPipe.setDx(5);
            last = tempPipe.getY() - tempPipe.getHeight();
            if (i < randWay || i > randWay + 4) {
                pipes.add(tempPipe);
            }
        }
    }


    public void tick() {
        Date date = new Date();
        int last = base;

        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).tick();

            if (pipes.get(i).getX() < -200) {
                pipes.remove(pipes.get(i));
            }
        }


        if (date.getTime() > timeMilli){
            timeMilli = date.getTime() + 2000;
            built++;
            int randWay = random.nextInt(10);
            if (built >= 3){
                score++;
                sound.play();
            }
            for (int i = 0; i < 20; i++) {

                Pipe tempPipe = new Pipe(800, last);
                tempPipe.setDx(5);
                last = tempPipe.getY() - tempPipe.getHeight();
                if (i < randWay || i > randWay + 4) {
                    pipes.add(tempPipe);
                }
            }
        }



    }

    public void render(Graphics2D g, ImageObserver obs) {
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).render(g, obs);
        }
        tick();
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    public int getScore(){ return score;}
}
