package org.example.user;

import org.example.objects.Bird;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class User extends KeyAdapter {
    private Bird bird;

    public User(){
    }


    public void controllerReleased(Bird bird, KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
        }
    }
}
