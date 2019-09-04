package Service.Managment;

import Listeners.ActionListener;
import FrameComponents.Button.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonManager {
    //TODO:: create ArrayList: calculatorButtons

    public static final int MAIN_MENU = 0, CALCULATOR = 1, TEMPO_DETECTOR = 2, BLOCK_DIAGRAM = 3;

    private ArrayList<Button> menuButtons = new ArrayList<>();

    public ButtonManager(){

        createMainMenuButtons();
    }

    private void createMainMenuButtons(){
        Button mainMenu = new Button("main-menu",new Color(175,100,100));
        Button calculator = new Button("calculator",new Color(175,100,100));
        Button tempoDetector = new Button("tempo-detector",new Color(175,100,100));
        Button blockDiagram = new Button("block-diagram",new Color(175,100,100));
        addButton(mainMenu);
        addButton(calculator);
        addButton(tempoDetector);
        addButton(blockDiagram);
    }

    private void addButton(Button button){
        menuButtons.add(button);
    }

    public ArrayList<Button> getMenuButtons(){
        return menuButtons;
    }

    public void addActionListener(ActionListener actionListener){
        for(JButton button : menuButtons){
            button.addActionListener(actionListener);
        }
    }
}
