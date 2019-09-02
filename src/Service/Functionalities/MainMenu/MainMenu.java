package Service.Functionalities.MainMenu;

import Service.Helpers.MenuBarHelper;

import javax.swing.*;

public class MainMenu {


    private MenuBarHelper menuBarHelper;

    public MainMenu(){
        initMenuBarHelper();
    }

    private void initMenuBarHelper(){
        menuBarHelper = new MenuBarHelper();
    }

    public JMenuBar getMenuBar(){
        return menuBarHelper.getMenuBar();
    }

}
