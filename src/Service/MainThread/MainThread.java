package Service.MainThread;

import Service.Service;

public class MainThread implements Runnable{
    private Service service;
    private TickHelper tickHelper;

    public MainThread(Service service){
        this.service = service;
        tickHelper = new TickHelper();
    }

    @Override
    public void run() {
        while(service.running){
            tickHelper.calcTime();

            while(tickHelper.readyToUpdate()){
                tickHelper.update();
                service.render();
            }
            service.update();
            tickHelper.reset();
        }
    }
    private class TickHelper {
        private int frames = 0;
        private long lastTime = System.nanoTime();
        private long timer = System.currentTimeMillis();
        private double delta = 0.0;
        private double ns = 1000000000.0/60.0;
        private int updates = 0;

        void calcTime(){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime = now;
            frames++;
        }

        boolean readyToUpdate() {
            return delta>=1;
        }

        void update(){
            updates++;
            delta--;
        }

        void reset(){
            if(System.currentTimeMillis()-timer>1000){
//                System.out.println("FPS: " + frames + ",\t updates: " + updates);
                timer+=1000;
                frames=0;
                updates=0;
            }
        }

    }

}
