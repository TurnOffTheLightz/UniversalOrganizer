package Service;

import FrameComponents.Frame.Frame;
import Service.MainThread.MainThread;
import Service.Prerequisites.Prerequisites;


public class Service {

    public boolean running = false;
    public static boolean exit = false; //TODO:: action listener will exit when needed
    private Thread thread;

    private Frame frame;

    private Prerequisites prerequisites = new Prerequisites();

    public Service(){
        init();
    }

    public void render(){
        frame.render();
    }

    public void update(){
        frame.update();

        checkExit();
    }

    private void init(){
        createFrame();
        running = true;
    }
    private void createFrame(){
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
