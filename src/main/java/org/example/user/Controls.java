package org.example.user;

import org.example.objects.Bird;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls extends KeyAdapter {
    private final User user;
    private Bird bird;

    public Controls(Bird bird) {
        this.user = new User();
        this.bird = bird;
    }


    public void keyReleased(KeyEvent e) {
        user.controllerReleased(bird, e);
    }

}
