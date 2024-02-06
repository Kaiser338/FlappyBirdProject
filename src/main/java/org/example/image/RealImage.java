package org.example.image;

import javax.swing.*;


public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
    }

    private void loadFromDisk(String fileName){
    }
}