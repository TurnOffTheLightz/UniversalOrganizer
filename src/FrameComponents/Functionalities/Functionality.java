package FrameComponents.Functionalities;

import FrameComponents.Button.Button;
import FrameComponents.Container.Container;
import Service.Interfaces.Card;
import FrameComponents.Helpers.LayoutHelper;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Functionality implements Card {
    /*
        used by a group of Objects that fit similar syntax
     */
    protected JPanel container = new Container();

    private ArrayList<Button> buttons = new ArrayList<>();

    protected ArrayList<JComponent> components = new ArrayList<>();

    protected LayoutHelper layoutHelper = new LayoutHelper();

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
    protected void addButtons(Button... buts){
        buttons.addAll(Arrays.asList(buts));
    }

    protected void addComponents(JComponent... comps){
        components.addAll(Arrays.asList(comps));
    }
}
