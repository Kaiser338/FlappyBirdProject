package org.example.objects;

import org.example.image.ProxyImage;
import org.example.sound.Sound;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

public class Bird extends Object{
    private ProxyImage proxyImage;
    private Sound sound;
    public Bird(int x, int y){
        super(x, y);
        ProxyImage img = new ProxyImage("birdd.png");
        this.image = img.getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x -= width;
        this.y -= height;
        this.dy = 1;
        sound = new Sound();
        sound.setFile(1);
    }

    public void tick() {
        this.y += (dy/15);
        if( this.dy <= 50 ){
            dy += 5;
        }

    }

    public void render(Graphics2D g, ImageObserver obs) {
        g.drawImage(this.image, x, y, obs);
        tick();
    }

    public void jump(){
        if (this.dy > 0){
            sound.play();
            this.dy = -100;
        }
    }

}
