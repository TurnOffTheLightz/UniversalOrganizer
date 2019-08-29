package Service.Helpers;

public class TickHelper {
    private int frames = 0;
    private long lastTime = System.nanoTime();
    private long timer = System.currentTimeMillis();
    private double delta = 0.0;
    private double ns = 1000000000.0/60.0;
    private int updates = 0;

    public void calcTime(){
        long now = System.nanoTime();
        delta+=(now-lastTime)/ns;
        lastTime = now;
        frames++;
    }

    public boolean readyToUpdate() {
        return delta>=1;
    }

    public void update(){
        updates++;
        delta--;
    }

    public void reset(){
        if(System.currentTimeMillis()-timer>1000){
            timer+=1000;
            frames=0;
            updates=0;
        }
    }

}
