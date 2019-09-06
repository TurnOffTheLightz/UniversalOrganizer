package FrameComponents.Functionalities;

import FrameComponents.Button.Button;
import FrameComponents.Container.Container;
import Service.Interfaces.Card;
import Service.Helpers.LayoutHelper;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Functionality implements Card {
    /*
        used by a group of Objects that fit similar syntax
     */
    protected JPanel container = new Container();

    protected ArrayList<Button> buttons = new ArrayList<>();

    protected LayoutHelper layoutHelper = new LayoutHelper();

    protected Functionality(){

    }
    /*
       getContainer() gets the whole container and all the objects inside
     */
    public JPanel getContainer(){
        return container;
    }
    /*
        passes components to ComponentManager getComponents
     */
    public ArrayList<Button> getButtons(){
        return buttons;
    }
    /*
        arraylist
     */
    protected void addButton(Button button){
        buttons.add(button);
    }


}
