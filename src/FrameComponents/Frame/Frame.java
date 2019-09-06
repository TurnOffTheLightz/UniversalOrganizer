package FrameComponents.Frame;

import Listeners.ActionListener;
import FrameComponents.Helpers.MenuBarHelper;
import Service.Managment.ComponentHandler;
import Service.Managment.CardManager;
import Service.Managment.ImageManager;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    /*
    Frame class stores data needed to move between cards(functionalities) in apps

        maybes:
        -not sure about preinitializing classes with constructor arguments
     */

    private final Dimension frameSize = new Dimension(800,800);

    private CardManager cardManager = new CardManager();

    private ComponentHandler componentHandler = new ComponentHandler(cardManager);

    private ActionListener actionListener = new ActionListener(componentHandler, cardManager);

    private MenuBarHelper menuBarHelper = new MenuBarHelper();

    /*
        functionalities:
        //TODO:: metronome (metronome/tempoDetector)
        //TODO:: calculator
        //TODO:: blockDiagram
        //TODO:: weekPlanner
     */

    //TODO:: image manager class
    private ImageManager imageManager = new ImageManager();

    public Frame(){
        setFrame();
        setMenuBar();
        //init buttonshere
        addContainer();
        addActionListener();
    }

    public void render(){

    }

    public void update(){

    }

    private void setMenuBar(){
        this.setJMenuBar(menuBarHelper.getMenuBar());
    }

    //adds the content container to frame
    private void addContainer(){ this.add(cardManager.getContainer()); }

    private void addActionListener(){
        componentHandler.addActionListener(actionListener);
    }

    //TODO::addChangeListener

    private void setFrame(){
        this.setTitle("Universal Organizer v0.1");
        this.setSize(frameSize);
        this.setFocusable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }
}
