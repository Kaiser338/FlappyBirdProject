package org.example;


import org.example.image.ProxyImage;
import org.example.objects.Bird;
import org.example.objects.Pipe;
import org.example.objects.Pipes;
import org.example.sound.Sound;
import org.example.user.Controls;
import org.example.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;


public class GameManager extends JPanel implements ActionListener {
    private BufferedImage img;
    private Bird bird;

    private User user;

    private int score;
    private Pipes pipes;
    public GameManager() {
        ProxyImage image = new ProxyImage("background.png");
        img = image.getImage();
        setFocusable(true);
        startGame();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, null);
        this.bird.render(g2, this);
        this.pipes.render(g2, this);
        endConditions();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }

    private void endConditions() {
        Rectangle rectBird = this.bird.getCollisions();
        rectBird.setSize(30, 24);
        if (this.bird.getY() >= 580){
            score = pipes.getScore();
            System.out.println("Wynik to: "+score);
            startGame();
        }

        for (int i = 0; i < this.pipes.getPipes().size(); i++) {
            Pipe pipe = this.pipes.getPipes().get(i);
            Rectangle rectPipe = pipe.getCollisions();
            if (rectBird.intersects(rectPipe)) {
                score = pipes.getScore();
                System.out.println("Wynik to: "+score);
                startGame();
            }
        }
    }

    private void startGame() {
        score = 0;
        this.bird = null;
        this.pipes = null;
        this.bird = new Bird(300, 300);
        this.pipes = new Pipes();
        addKeyListener(new Controls(this.bird));
        Timer timer = new Timer(15, this);
        timer.start();
    }

}
