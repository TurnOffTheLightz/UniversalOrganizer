package Service.Managment;

import Listeners.ActionListener;
import FrameComponents.Button.Button;
import Listeners.ChangeListener;

import javax.swing.*;
import java.util.ArrayList;

public class ComponentHandler {
    /*
             ComponentHandler is a class responsible for passing on components (buttons, labels, sliders, etc.)
              mainly used by listeners
     */

    private CardManager cardManager;

    ComponentHandler(CardManager cardManager){
        this.cardManager = cardManager;
    }

    //menu
    public ArrayList<Button> getPinnedMenuButtons(){
        return cardManager.getPinnedMenu().getButtons();
    }

    //metronome
    public ArrayList<Button> getMetronomeButtons(){
        return cardManager.getMetronome().getButtons();
    }

    public JSlider getMetronomeSlider(){ return cardManager.getMetronome().getSlider(); }

    public JTextField getMetronomeTextField() {
        return cardManager.getMetronome().getTextField();
    }

    public ArrayList<JRadioButton> getMetronomeRadioButtons(){
        return cardManager.getMetronome().getRadioButtons();
    }

    //add listeners
    public void addActionListener(ActionListener actionListener){
        //menu
        for(JButton button : cardManager.getPinnedMenu().getButtons()){
            button.addActionListener(actionListener);
        }
        //metronome
        //buttons
        for(JButton button  : cardManager.getMetronome().getButtons()){
            button.addActionListener(actionListener);
        }
        //radio buttons
        for(JRadioButton rb : cardManager.getMetronome().getRadioButtons()){
            rb.addActionListener(actionListener);
        }
        //textfield
        cardManager.getMetronome().getTextField().addActionListener(actionListener);
    }
    public void addChangeListener(ChangeListener changeListener){
        cardManager.getMetronome().getSlider().addChangeListener(changeListener);
    }
}
