package Service.Helpers;

import javax.swing.*;

public class MenuHelper {
    //TODO:: more options in menubar, add functionality
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JMenuItem open;
    private JMenuItem exit;

    public MenuHelper(JMenuBar menuBar){
        this.menuBar = menuBar;
        init();
    }

    public JMenuBar getMenuBar(){
        return this.menuBar;
    }

    private void init(){
        menu = new JMenu("file");

        save = new JMenuItem("file");
        open = new JMenuItem("open");
        exit = new JMenuItem("exit");
        menu.add(save);
        menu.add(open);
        menu.add(exit);

        menuBar.add(menu);
    }
}
