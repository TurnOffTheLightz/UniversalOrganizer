package Service.Helpers;

import Service.Managment.ButtonManager;
import Service.Managment.LayoutManager;

import java.awt.event.ActionEvent;

public class ActionHelper {

    private LayoutManager layoutManager;

    private ButtonManager buttonManager;

    public ActionHelper(LayoutManager layoutManager, ButtonManager buttonManager){
        this.layoutManager = layoutManager;
        this.buttonManager = buttonManager;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonManager.getMenuButtons().get(ButtonManager.MAIN_MENU)){
            layoutManager.swapCard("main-menu");
        }
        else if(e.getSource() == buttonManager.getMenuButtons().get(ButtonManager.CALCULATOR)){
            layoutManager.swapCard("calculator");
        }
        else if(e.getSource() == buttonManager.getMenuButtons().get(ButtonManager.TEMPO_DETECTOR)){
            layoutManager.swapCard("tempo-detector");
        }
        else if(e.getSource() == buttonManager.getMenuButtons().get(ButtonManager.BLOCK_DIAGRAM)){
            layoutManager.swapCard("block-diagram");
        }
    }
}
