package Service.Helpers;

import javax.swing.*;

public class MenuBarHelper {

    //TODO:: more options in menubar, add functionality to menuItems
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JMenuItem open;
    private JMenuItem exit;

    public MenuBarHelper(){
        init();
    }

    public JMenuBar getMenuBar(){
        return this.menuBar;
    }

    private void init(){
        menuBar = new JMenuBar();

        menu = new JMenu("file");

        save = new JMenuItem("save");
        open = new JMenuItem("open");
        exit = new JMenuItem("exit");
        menu.add(save);
        menu.add(open);
        menu.add(exit);

        menuBar.add(menu);
    }
}
