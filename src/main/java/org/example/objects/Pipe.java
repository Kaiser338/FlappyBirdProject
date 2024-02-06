package org.example.objects;

import org.example.image.ProxyImage;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Pipe extends Object{

    public Pipe(int x, int y){
        super(x, y);
        ProxyImage img = new ProxyImage("TubeBody.png");
        this.image = img.getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public void tick() {
        this.x -= 2;
    }

    public void render(Graphics2D g, ImageObserver obs) {
        g.drawImage(this.image, x, y, obs);
    }

}
