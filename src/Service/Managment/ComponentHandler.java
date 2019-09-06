package Service.Managment;

import Listeners.ActionListener;
import FrameComponents.Button.Button;

import javax.swing.*;
import java.util.ArrayList;

public class ComponentHandler {
    /*
    ButtonManager is a class responsible for holding and managing all buttons
     */
    public static final int MAIN_MENU = 0, CALCULATOR = 1, METRONOME = 2, BLOCK_DIAGRAM = 3;
    public static final int METRONOME_PLAY_BUTTON = 0, METRONOME_STOP_BUTTON = 1, METRONOME_CLICKER_BUTTON = 2;

    private ArrayList<Button> pinnedMenuButtons = new ArrayList<>();

    private ArrayList<Button> metronomeButtons = new ArrayList<>();

    private CardManager cardManager;

    public ComponentHandler(CardManager cardManager){
        this.cardManager = cardManager;
        setComponents();
    }

    private void setComponents(){
        setPinnedMenuComponents();
        setMetronomeComponents();
    }

    private void setPinnedMenuComponents(){
        for(Button b : cardManager.getPinnedMenu().getButtons()){
            addButton(pinnedMenuButtons,b);
        }
    }

    private void setMetronomeComponents(){
        for(Button b : cardManager.getMetronome().getButtons()){
            addButton(metronomeButtons,b);
        }
        //TODO:: slider and textfield
    }

    private void addButton(ArrayList<Button> buttons, Button b){
        buttons.add(b);
    }

    public ArrayList<Button> getPinnedMenuButtons(){
        return pinnedMenuButtons;
    }

    ArrayList<Button> getMetronomeButtons(){
        return metronomeButtons;
    }

    public void addActionListener(ActionListener actionListener){
        for(JButton button : pinnedMenuButtons){
            button.addActionListener(actionListener);
        }
        for(JButton button  : metronomeButtons){
            button.addActionListener(actionListener);
        }
    }
}
