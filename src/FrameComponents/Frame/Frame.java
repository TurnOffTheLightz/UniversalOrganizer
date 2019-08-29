package FrameComponents.Frame;

import FrameComponents.Canvas.Canvas;
import Listeners.MouseListener;
import Service.Helpers.MenuHelper;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    private final Dimension frameSize = new Dimension(800,600);

    private Canvas canvas;

    private JMenuBar menuBar;
    private MenuHelper menuHelper;

    public Frame(){
        initFrame();
        initCanvas();
        initMenu();
        initMouseListener();
    }

    public void renderCanvas() {
        canvas.render();
    }


    private void initFrame(){
        this.setTitle("Organizer");
        this.setSize(frameSize);
        this.setFocusable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initCanvas(){
        canvas = new Canvas();
        this.add(canvas);
    }

    private void initMenu(){
        menuBar = new JMenuBar();
        menuHelper = new MenuHelper(menuBar);

        this.setJMenuBar(menuHelper.getMenuBar());
    }

    private void initMouseListener(){
        MouseListener mouseListener = new MouseListener();
        canvas.addMouseListener(mouseListener);
    }

}
