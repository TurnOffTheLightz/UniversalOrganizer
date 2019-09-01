package FrameComponents.Frame;

import Controllers.MouseController;
import Service.Helpers.ContainerManager;
import Service.ImageService;
import Service.LayoutService;
import Service.Functionalities.MainMenu.MainMenu;
import Service.State.State;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    //TODO:: Add "add text area" button

    private final Dimension frameSize = new Dimension(800,800);

    private ContainerManager containerManager;

    private Canvas canvas;

    private MainMenu mainMenu;

    private MouseController mouseController;

    private ImageService imageService = new ImageService();

    private LayoutService layoutService;

    public Frame(){
        initContainerHelper();
        initCanvas();
        initMainMenu();
        initFrame();
        initMouseListener();
        createLayoutService();
    }
    public void render(Graphics2D g){
        if(State.state == State.mainMenu){
            renderBackground(g);
            mainMenu.render(g);
        }
    }
    private void renderBackground(Graphics2D g){
        g.setColor(imageService.getBackgroundColor());
        g.fillRect(canvas.getX(),canvas.getY(),canvas.getWidth(),canvas.getHeight());
    }

    public void update(){

        System.out.println(containerManager.getBaseContainer().getLayout());
        if(State.state == State.mainMenu){
            checkMousePress();
            mainMenu.update();
        }
    }

    private void checkMousePress(){
        if(MouseController.mousePressed) {
            mainMenu.mousePress();
        }
        //TODO:: Tempo Detector state
        //TODO:: Calculator state
    }

    private void createLayoutService(){
        layoutService = new LayoutService(containerManager);
    }
    private void initContainerHelper() {
        containerManager = new ContainerManager();
        this.add(containerManager.getBaseContainer());
    }
    private void initCanvas() {
        canvas = new Canvas();
//        container.add(canvas);
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

    public Canvas getCanvas(){
        return canvas;
    }
    public MainMenu getMainMenu(){ return mainMenu; }
}
