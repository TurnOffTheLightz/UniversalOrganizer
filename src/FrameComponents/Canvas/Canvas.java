package FrameComponents.Canvas;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Canvas extends java.awt.Canvas {

    private BufferStrategy bs;
    private Graphics g;

    public Canvas(){

    }

    public void render() {
        bs = getBufferStrategy();
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        printRectangle(g,Color.yellow,0,0,getWidth(),getHeight());
        printRectangle(g,Color.green,100,100,400,400);
        printRectangle(g,Color.red,200,200,300,300);
        printRectangle(g,Color.LIGHT_GRAY,300,300,200,200);

        g.dispose();
        bs.show();
    }

    private void printRectangle(Graphics g, Color c, int x, int y, int w,int h){
        g.setColor(c);
        g.fillRect(x,y,w,h);
    }
}
