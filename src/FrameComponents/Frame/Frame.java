package FrameComponents.Frame;

import Listeners.ActionListener;
import FrameComponents.Helpers.MenuBarHelper;
import Listeners.ChangeListener;
import Service.Managment.CardManager;
import Service.Managment.ImageManager;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    /*
            Frame class stores data needed to move between cards(functionalities)

        maybes:
        -not sure about preinitializing classes with constructor arguments
     */

    private final Dimension frameSize = new Dimension(800,800);

    private ImageManager imageManager = new ImageManager();

    private CardManager cardManager = new CardManager();

    //todo:: move into card manager

    private ActionListener actionListener = new ActionListener(cardManager);

    private ChangeListener changeListener = new ChangeListener(cardManager);

    private MenuBarHelper menuBarHelper = new MenuBarHelper();

    public Frame(){
        setFrame();
        setMenuBar();

        addContainer();
        addActionListener();
        addChangeListener();
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
        cardManager.getComponentHandler().addActionListener(actionListener);
    }

    private void addChangeListener() { cardManager.getComponentHandler().addChangeListener(changeListener);}

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
