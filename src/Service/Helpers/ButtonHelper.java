package Service.Helpers;

import FrameComponents.Button.Button;
import Service.State.State;

import java.awt.*;
import java.util.ArrayList;

public class ButtonHelper {
    //TODO:: separate group of buttons for proper functionality

    private final int mainMenuButtonSize = 400;
    private final Rectangle tempoDetectorBounds = new Rectangle(0,0,mainMenuButtonSize,mainMenuButtonSize);
    private final Rectangle blockDiagramBounds = new Rectangle(400,0,mainMenuButtonSize,mainMenuButtonSize);
    private final Rectangle calculatorBounds = new Rectangle(0,400,mainMenuButtonSize,mainMenuButtonSize);

    private ArrayList<Button> mainMenuButtons = new ArrayList<>();

    public ButtonHelper(){

        init();
    }

    public void render(Graphics g){
        renderMainMenuButtons(g);
    }

    private void renderMainMenuButtons(Graphics g){
        for (Button b : mainMenuButtons) {
            b.render(g);
        }
    }

    public void update(){
        updateMainMenuButtons();
    }
    private void updateMainMenuButtons(){ //not sure if update will be needed in future
        if(State.state == State.mainMenu){
            for(Button b : mainMenuButtons){
                b.update();
            }
        }
    }

    private void init(){
        createMainMenuButtons();
    }
    private void createMainMenuButtons(){
        Button tempoDetector = new Button(tempoDetectorBounds,"tempo-detector",new Color(255,255,0));
        Button blockDiagram = new Button(blockDiagramBounds,"block-diagram",new Color(0,255,255));
        Button calculator = new Button(calculatorBounds,"calculator",new Color(255,0,255));
        addButton(tempoDetector);
        addButton(blockDiagram);
        addButton(calculator);
    }

    private void addButton(Button button){
        mainMenuButtons.add(button);
    }

    public ArrayList<Button> getMainMenuButtons(){
        return mainMenuButtons;
    }



}
