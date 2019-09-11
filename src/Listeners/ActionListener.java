package Listeners;

import Service.Managment.CardManager;
import Service.Managment.ComponentHandler;
import Service.State.State;

import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    /*
                handles button clicks
     */
    //to access action objects
    private ComponentHandler componentHandler;
    //to acces card swap
    private CardManager cardManager;

    public ActionListener(CardManager cardManager){
        this.componentHandler = cardManager.getComponentHandler();
        this.cardManager = cardManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handlePinnedMenu(e.getSource());
        if(State.metronomeOpen())
            handleMetronome(e.getSource());
    }

    //pinned menu
    private void handlePinnedMenu(Object e){
        if(e == componentHandler.getPinnedMenuButtons().get(ComponentHandler.MAIN_MENU)){
            cardManager.swapCard("main-menu");
        }
        else if(e == componentHandler.getPinnedMenuButtons().get(ComponentHandler.CALCULATOR)){
            cardManager.swapCard("calculator");
        }
        else if(e == componentHandler.getPinnedMenuButtons().get(ComponentHandler.METRONOME)){
            cardManager.swapCard("metronome");
        }
        else if(e== componentHandler.getPinnedMenuButtons().get(ComponentHandler.BLOCK_DIAGRAM)){
            cardManager.swapCard("block-diagram");
        }
    }

    //metronome
    private void handleMetronome(Object e){
        //buttons
        if(e == componentHandler.getMetronomeButtons().get(ComponentHandler.METRONOME_PLAY_BUTTON)){
            cardManager.getMetronome().startTicking();
        }
        if(e == componentHandler.getMetronomeButtons().get(ComponentHandler.METRONOME_STOP_BUTTON)){
            cardManager.getMetronome().stopTicking();
        }
        if(e == componentHandler.getMetronomeButtons().get(ComponentHandler.METRONOME_CLICKER_BUTTON)){
            cardManager.getMetronome().updateClicker();
        }
        //slider
        if(e == componentHandler.getMetronomeTextField()){
            componentHandler.getMetronomeSlider().setValue(Integer.parseInt(componentHandler.getMetronomeTextField().getText()));
        }
        //radio buttons
        if(e == componentHandler.getMetronomeRadioButtons().get(ComponentHandler.METRONOME_RADIO_2)){
            cardManager.getMetronome().setKlackValue(2);
        }
        if(e == componentHandler.getMetronomeRadioButtons().get(ComponentHandler.METRONOME_RADIO_3)){
            cardManager.getMetronome().setKlackValue(3);
        }
        if(e == componentHandler.getMetronomeRadioButtons().get(ComponentHandler.METRONOME_RADIO_4)){
            cardManager.getMetronome().setKlackValue(4);
        }
    }
}
