package Service.Functionalities.MainMenu;

import Service.Helpers.ButtonHelper;
import Service.Helpers.MenuBarHelper;

import javax.swing.*;
import java.awt.*;

public class MainMenu {

    private MenuBarHelper menuBarHelper;
    private ButtonHelper buttonHelper;


    public MainMenu(){
        initMenuBarHelper();
        initButtonHelper();
    }

    public void render(Graphics g){
        buttonHelper.render(g);
    }

    public void update(){
        buttonHelper.update();
    }
    public void mousePress(){
        buttonHelper.mousePress();
    }

    private void initMenuBarHelper(){
        menuBarHelper = new MenuBarHelper();
    }
    private void initButtonHelper(){
        buttonHelper = new ButtonHelper();
    }

    public JMenuBar getMenuBar(){
        return menuBarHelper.getMenuBar();
    }
    public ButtonHelper getButtonHelper(){
        return buttonHelper;
    }

}
