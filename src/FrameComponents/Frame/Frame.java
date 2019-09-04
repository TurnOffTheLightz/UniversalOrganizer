package FrameComponents.Frame;

import Listeners.ActionListener;
import Service.Helpers.MenuBarHelper;
import Service.Managment.ButtonManager;
import Service.Helpers.ActionHelper;
import Service.Managment.ContainerManager;
import Service.Managment.ImageManager;
import Service.Managment.LayoutManager;
import Service.Functionalities.MainMenu.MainMenu;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    /*
    Frame class stores data needed to move between cards(functionalities) in apps

        maybes:
        -not sure about preinitializing classes with constructor arguments
     */
    private final Dimension frameSize = new Dimension(800,800);

    private ButtonManager buttonManager = new ButtonManager();

    private ContainerManager containerManager=  new ContainerManager(buttonManager);

    private LayoutManager layoutManager = new LayoutManager(containerManager);

    private ActionHelper actionHelper = new ActionHelper(layoutManager, buttonManager);

    private ActionListener actionListener = new ActionListener(actionHelper);

    private MenuBarHelper menuBarHelper = new MenuBarHelper();

    //TODO:: image manager class
    private ImageManager imageManager = new ImageManager();

    public Frame(){
        setFrame();
        setMenuBar();
        addContainers();
        addButtons();
        addBaseContainerToFrame();
        addActionListenerToButtons();
    }

    public void render(){
        containerManager.render();
    }

    public void update(){

    }

    private void setMenuBar(){
        this.setJMenuBar(menuBarHelper.getMenuBar());
    }

    private void addBaseContainerToFrame(){ this.add(containerManager.getBaseContainer()); }

    private void addButtons(){ layoutManager.addButtons(); }

    private void addContainers(){ containerManager.addContainersToBaseContainer(); }

    private void addActionListenerToButtons(){
        buttonManager.addActionListener(actionListener);
    }

    private void setFrame(){
        this.setTitle("Universal Organizer v0.1");
        this.setSize(frameSize);
        this.setFocusable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
