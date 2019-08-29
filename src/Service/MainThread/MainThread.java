package Service.MainThread;

import Service.Editor.Editor;
import Service.Helpers.TickHelper;

public class MainThread implements Runnable{

    private Editor editor;
    private TickHelper tickHelper;

    public MainThread(Editor editor){
        this.editor = editor;
        tickHelper = new TickHelper();
    }

    @Override
    public void run() {
        while(editor.running){
            tickHelper.calcTime();

            while(tickHelper.readyToUpdate()){
                editor.update();
                tickHelper.update();
            }
            editor.render();
            tickHelper.reset();
        }
    }
}
