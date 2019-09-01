package Service;

import Controllers.MouseController;
import FrameComponents.Button.Button;
import Service.Helpers.ContainerManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LayoutService {

    private JPanel baseContainer;
    private ContainerManager containerManager;

    //TODO:: add more containers


    private CardLayout cardLayout = new CardLayout();

    public LayoutService(ContainerManager containerManager){
        this.containerManager = containerManager;
        setCardLayout();
    }


    private void setCardLayout(){
        baseContainer.setLayout(cardLayout);
        changeContainerBackGroundColor();

    }

    private void changeContainerBackGroundColor(){
        baseContainer.setBackground(new Color(0,0,100));
    }

    public static void pressButton(ArrayList<Button> buttonList){
        for(Button b : buttonList){
            if(b.pressed()){
                //TODO:: add card layout and start proper functionality
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
