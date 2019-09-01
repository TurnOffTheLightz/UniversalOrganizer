package Service.Helpers;

import FrameComponents.Button.Button;
import Service.LayoutService;

import java.awt.*;
import java.util.ArrayList;

public class ButtonHelper {

    private final int mainMenuButtonSize = 400;
    private final Rectangle tempoDetectorBounds = new Rectangle(0,0,mainMenuButtonSize,mainMenuButtonSize);
    private final Rectangle blockDiagramBounds = new Rectangle(400,0,mainMenuButtonSize,mainMenuButtonSize);
    private final Rectangle calculatorBounds = new Rectangle(0,400,mainMenuButtonSize,mainMenuButtonSize);

    private ArrayList<Button> buttonList = new ArrayList<>();

    public ButtonHelper(){

        init();
    }
    public void render(Graphics g){
        for(Button b : buttonList){
            b.render(g);
        }
    }

    public void update(){
        for(Button b : buttonList){
            b.update();
        }
    }

    public void mousePress(){
        if(LayoutService.anyButtonPressed(buttonList)){
            LayoutService.pressButton(buttonList);
        }
    }

    private void init(){
        Button tempoDetector = new Button(tempoDetectorBounds,"tempo-detector",new Color(255,255,0));
        Button blockDiagram = new Button(blockDiagramBounds,"block-diagram",new Color(0,255,255));
        Button calculator = new Button(calculatorBounds,"calculator",new Color(255,0,255));

        addButton(tempoDetector);
        addButton(blockDiagram);
        addButton(calculator);
    }

    private void addButton(Button button){
        buttonList.add(button);
    }



}
