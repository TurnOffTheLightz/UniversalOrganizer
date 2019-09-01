package Service;

import FrameComponents.Frame.Frame;
import Service.MainThread.MainThread;
import Service.Prerequisites.Prerequisites;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Service {
    public boolean running = false;
    private boolean exit = false;

    private Frame frame;

    private Thread thread;

    private Prerequisites prerequisites;

    private Canvas frameCanvas;
    private BufferStrategy bs;
    private Graphics2D g;


    public Service(){

        init();
    }


    public void render(){
        bs = frameCanvas.getBufferStrategy();
        if(bs==null){
            frameCanvas.createBufferStrategy(3);
            return;
        }
        g = (Graphics2D) bs.getDrawGraphics();

        frame.render(g);

        g.dispose();
        bs.show();
    }


    //TODO:: update method will check mouse action and react as we want
    public void update(){
        updateFrameCanvas();
        frame.update();

        checkExit();
    }
    private void updateFrameCanvas(){
        frameCanvas = frame.getCanvas();
    }

    private void init(){
        running = true;

        createFrame();
        createPrerequisites();
        setFrameCanvas();
    }
    private void createFrame(){
        frame = new Frame();
    }
    private void createPrerequisites(){
        prerequisites = new Prerequisites();
    }
    private void setFrameCanvas(){
        frameCanvas = frame.getCanvas();
    }

    public synchronized void start(){
        thread = new Thread(new MainThread(this));
        thread.start();
    }

    private synchronized void stop(){
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void checkExit(){
        if(exit){
            running=false;
            stop();
            System.exit(0);
        }
    }
}
