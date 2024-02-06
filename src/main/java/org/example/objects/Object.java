package org.example.objects;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.ImageObserver;

@Getter
@Setter
public abstract class Object {
    protected int x, y;
    protected double dx, dy;

    protected  int degree;
    protected int width, height;
    protected Image image;

    public Object(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics2D g, ImageObserver obs);

    public Rectangle getCollisions() {
        return new Rectangle(x, y, width, height);
    }
}
