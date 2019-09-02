package FrameComponents.Frame;

import Controllers.MouseController;
import Service.Helpers.ButtonHelper;
import Service.Helpers.MouseHelper;
import Service.Managment.ContainerManager;
import Service.Managment.ImageManager;
import Service.Managment.LayoutManager;
import Service.Functionalities.MainMenu.MainMenu;
import Service.State.State;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    /*
    Frame class stores data needed to move between cards(functionalities) in apps

        maybes:
        -not sure about preinitializing classes with constructor arguments
     */

    //TODO::MouseHelper class, needs buttonHelper
    private final Dimension frameSize = new Dimension(800,800);

    private ContainerManager containerManager;
    private JPanel baseContainer;
    private Canvas canvas;

    private ButtonHelper buttonHelper = new ButtonHelper();

    private MouseHelper mouseHelper = new MouseHelper(buttonHelper);

    private MainMenu mainMenu;

    private MouseController mouseController;

    private ImageManager imageManager = new ImageManager();

    private LayoutManager layoutManager;

    public Frame(){
        initContainerHelper();
        initCanvas();
        initMainMenu();
        initFrame();
        initMouseListener();
        createLayoutManager();
    }

    public void render(Graphics g){
        if(State.state == State.mainMenu){
            renderBackground(g);
            buttonHelper.render(g);
        }
    }

    private void renderBackground(Graphics g){
        g.setColor(imageManager.getBackgroundColor());
        g.fillRect(canvas.getX(),canvas.getY(),canvas.getWidth(),canvas.getHeight());
    }
    //TODO:: create ButtonHelper

    public void update(){
//        System.out.println(containerManager.getBaseContainer().getLayout());
        mouseHelper.update();
        buttonHelper.update();
    }

    private void createLayoutManager(){
        layoutManager = new LayoutManager(containerManager);
    }

    private void initContainerHelper() {
        containerManager = new ContainerManager();
        setBaseContainer();
    }

    private void initCanvas() {
        canvas = new Canvas();
//        baseContainer.add(canvas);
        this.add(canvas);
    }

    private void initMainMenu(){
        mainMenu = new MainMenu();
        this.setJMenuBar(mainMenu.getMenuBar());
        State.state = State.mainMenu;
    }

    private void initFrame(){
        this.setTitle("Universal Organizer");
        this.setSize(frameSize);
        this.setFocusable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void initMouseListener(){
        mouseController = new MouseController();
        canvas.addMouseListener(mouseController);
    }

    private void setBaseContainer(){
        baseContainer = containerManager.getBaseContainer();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public MainMenu getMainMenu(){ return mainMenu; }
}
