package FrameComponents.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends JButton {
    /*
    Button stores information like bounds, text, position, image etc.
     */

    //TODO::add graphics and animations
    private BufferedImage image;
    //meanwhile:
    private Color color;


    public Button(String text, Color color) {
        super(text);
        this.color = color;
    }
    public Button(String text){
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
