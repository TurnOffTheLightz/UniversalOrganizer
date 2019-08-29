package Service.Editor;

import FrameComponents.Canvas.Canvas;
import FrameComponents.Frame.Frame;
import Service.MainThread.MainThread;

import javax.swing.*;

public class Editor{
    public boolean running = false;
    public boolean exit = false;

    private Frame frame;

    private Thread thread;

    public Editor(){
        init();
    }

    //TODO:: update method
    public void update(){

        checkExit();
    }

    //TODO:: render method
    public void render(){
        frame.renderCanvas();
    }

    private void init(){
        running = true;
        frame = new Frame();
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
