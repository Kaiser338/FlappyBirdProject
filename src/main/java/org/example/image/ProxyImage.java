
package org.example.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }


    public BufferedImage getImage() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }

        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/"+this.fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }

    @Override
    public void display() {

    }
}