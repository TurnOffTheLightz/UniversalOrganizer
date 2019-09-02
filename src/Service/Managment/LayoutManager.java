package Service.Managment;

import Controllers.MouseController;
import FrameComponents.Button.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LayoutManager {
    private JPanel baseContainer;
    private ContainerManager containerManager;

    //TODO:: add more containers
    //TODO:: setLayout in Frame baseContainer


    private CardLayout cardLayout = new CardLayout();

    public LayoutManager(ContainerManager containerManager){
        this.containerManager = containerManager;
        setBaseContainer();
        setCardLayout();
    }


    private void setCardLayout(){
        changeContainerBackGroundColor();
    }

    private void setBaseContainer(){
        this.baseContainer = containerManager.getBaseContainer();
    }

    private void changeContainerBackGroundColor(){
        baseContainer.setBackground(new Color(0,0,100));
    }

    public static void pressButton(ArrayList<Button> buttonList){
        for(Button b : buttonList){
            if(b.pressed()){
                //TODO:: add card layout and start proper functionality
                //TODO:: check which button was pressed
            }
        }
    }
    public static boolean anyButtonPressed(ArrayList<Button> buttonList){
        for(Button b : buttonList){
            if(b.getBounds().contains(MouseController.mousePressX, MouseController.mousePressY)){
                b.setPressed(true);
                return true;
            }
        }
        return false;
    }
}
