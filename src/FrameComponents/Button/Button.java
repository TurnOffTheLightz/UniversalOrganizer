package FrameComponents.Button;

import Service.State.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends java.awt.Button {
    /*
    Button stores information like bounds, text, position, image etc.
     */
    private String text;
    private Rectangle bounds;

    //TODO::add graphics and animations
    private BufferedImage image;
    //meanwhile:
    private Color color;

    private boolean pressed = false;

    public Button(Rectangle bounds,String text, Color color){
        this.bounds = bounds;
        this.text = text;
        this.color = color;
    }

    public void render(Graphics g){
        renderImage(g);
        changeButtonColor(g);
        renderText(g);
    }

    private void changeButtonColor(Graphics g){
        if(pressed){
            g.setColor(new Color(0,150,0));
            g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        }
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void setPressed(boolean pressed){
        this.pressed = pressed;
    }

    public boolean pressed(){
        return pressed;
    }

    public String getText(){
        return text;
    }

    private void renderImage(Graphics g){
        g.setColor(color);
        g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
    }
    private void renderText(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 22));
        g.drawString(text,getTextPosition().x,getTextPosition().y);
    }
    private Point getTextPosition(){
        return new Point(bounds.x+bounds.width/3,bounds.y+bounds.height/2);
    }

    public void update() {

    }

    public State getState(){
        if(text.equals("main-menu")) return State.mainMenu;
        if(text.equals("tempo-detector")) return State.tempoDetector;
        if(text.equals("block-diagram")) return State.blockDiagram;
        if(text.equals("calculator")) return State.calculator;
        return null;
    }
}
