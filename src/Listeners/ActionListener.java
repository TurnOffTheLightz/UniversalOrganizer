package Listeners;

import Service.Managment.CardManager;
import Service.Managment.ComponentHandler;

import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    /*
                handles button clicks
     */
    //to access action objects
    private ComponentHandler componentHandler;
    //to acces card swap
    private CardManager cardManager;

    public ActionListener(ComponentHandler componentHandler, CardManager cardManager){
        this.componentHandler = componentHandler;
        this.cardManager = cardManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkMenuButtonClick(e);
    }
    private void checkMenuButtonClick(ActionEvent e){
        if(e.getSource() == componentHandler.getPinnedMenuButtons().get(ComponentHandler.MAIN_MENU)){
            cardManager.swapCard("main-menu");
        }
        else if(e.getSource() == componentHandler.getPinnedMenuButtons().get(ComponentHandler.CALCULATOR)){
            cardManager.swapCard("calculator");
        }
        else if(e.getSource() == componentHandler.getPinnedMenuButtons().get(ComponentHandler.METRONOME)){
            cardManager.swapCard("metronome");
        }
        else if(e.getSource() == componentHandler.getPinnedMenuButtons().get(ComponentHandler.BLOCK_DIAGRAM)){
            cardManager.swapCard("block-diagram");
        }
    }
}
