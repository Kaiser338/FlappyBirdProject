package org.example;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(){

    }
    public void CreateWindow(int width, int height, String title, GameManager game) {
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximumSize(new Dimension(width, height));
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }



    public void startGame(){
        GameManager game = new GameManager();
        CreateWindow(Main.WIDTH, Main.HEIGHT, "Flappy Bird", game);
    }
}
