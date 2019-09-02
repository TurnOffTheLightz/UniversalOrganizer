package Service.Helpers;

import Controllers.MouseController;
import FrameComponents.Button.Button;
import Service.State.State;

public class MouseHelper {

    ButtonHelper buttonHelper;

    public MouseHelper(ButtonHelper buttonHelper){
        this.buttonHelper = buttonHelper;
    }

    public void update(){
        checkMousePress();
        checkMouseRelease();
    }

    private void checkMousePress(){
        if(MouseController.mousePressed) {
            MouseController.mousePressed = false;
            mousePressed();
        }
    }

    private void checkMouseRelease(){
        if(MouseController.mouseReleased){
            MouseController.mouseReleased = false;
            mouseReleased();
        }
    }

    private void mousePressed(){
        if(mainMenuOpen()){
            if(anyButtonPressed()){//TODO::consider try catching NullPointer exception and deleting anyButtonPressed method
                getPressedMainMenuButton().setPressed(true);
                pressMainMenuButton(getPressedMainMenuButton());
            }
        }
    }

    private void pressMainMenuButton(Button pressedMainMenuButton){
        //TODO:: change proper card
    }

    private void mouseReleased(){
        if(mainMenuOpen()){
            if(anyButtonPressed())//TODO::consider try catching NullPointer exception and deleting anyButtonPressed method
                getPressedMainMenuButton().setPressed(false);
        }

    }

    private Button getPressedMainMenuButton(){
        for(Button b : buttonHelper.getMainMenuButtons()){
            if(b.getBounds().contains(MouseController.mousePressX, MouseController.mousePressY)){
                return b;
            }
        }
        return null;
    }

    private boolean mainMenuOpen(){
        return State.state == State.mainMenu;
    }

    private boolean anyButtonPressed(){
        for(Button b : buttonHelper.getMainMenuButtons()){
            if(b.getBounds().contains(MouseController.mousePressX, MouseController.mousePressY)){
                return true;
            }
        }
        return false;
    }
}
