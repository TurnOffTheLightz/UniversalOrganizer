package Listeners;

import Service.Managment.CardManager;
import Service.Managment.ComponentHandler;

import javax.swing.event.ChangeEvent;

public class ChangeListener implements javax.swing.event.ChangeListener {

    private ComponentHandler componentHandler;

    private CardManager cardManager;


    public ChangeListener(CardManager cardManager) {
        this.componentHandler = cardManager.getComponentHandler();
        this.cardManager = cardManager;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        handleMetronome(e.getSource());
    }

    private void handleMetronome(Object e){
        //slider
        if(e == componentHandler.getMetronomeSlider()){
            componentHandler.getMetronomeTextField().setText(Integer.toString(componentHandler.getMetronomeSlider().getValue()));
        }
    }
}
