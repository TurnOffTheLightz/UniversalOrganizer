package FrameComponents.Helpers;

import Service.Managment.ComponentHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LayoutHelper {

    private final int METRONOME_PLAY_BUTTON = 0, METRONOME_STOP_BUTTON = 1, METRONOME_CLICKER_BUTTON =2, METRONOME_SLIDER = 3, METRONOME_TEXTFIELD = 4, METRONOME_IMAGE_LABEL = 5, METRONOME_RADIO_BOX = 6;

    /*
            helps to deal with layouts, much of them
     */

    //soon replaced with addComponent

    //adds component to container with specified layout preferences
    private void addComponent(JPanel container, JComponent component, int x, int y, int w, int h, double wx, double wy, int padx, int pady, int place, int stretch){
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = w;
        gc.gridheight = h;
        gc.weightx = wx;
        gc.weighty = wy;
        gc.ipadx = padx;
        gc.ipady = pady;
        gc.insets = new Insets(3,3,3,3);
        gc.anchor = place;
        gc.fill = stretch;
        container.add(component,gc);
    }

    //used by Metronome class to just one-call-method to set all component layouts
    public void addMetronomeComponents(JPanel container, ArrayList<JComponent> components){

        addComponent(container,components.get(METRONOME_SLIDER),        0,0,4,1,1,0,0,0,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        addComponent(container,components.get(METRONOME_PLAY_BUTTON),   0,1,2,1,1,1,0,25,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL);
        addComponent(container,components.get(METRONOME_STOP_BUTTON),   1,1,2,1,1,1,0,25,GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL);
        addComponent(container,components.get(METRONOME_TEXTFIELD),     0,2,1,1,1,50,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        addComponent(container,components.get(METRONOME_CLICKER_BUTTON),2,2,2,2,1,1,0,0,GridBagConstraints.SOUTHEAST,GridBagConstraints.BOTH);
        addComponent(container,components.get(METRONOME_IMAGE_LABEL),   0,3,1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        addComponent(container,components.get(METRONOME_RADIO_BOX),     0,2,1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE);
    }

    public void addPinnedMenuComponents(JPanel container, ArrayList<JComponent> components){

        addComponent(container,components.get(ComponentHandler.MAIN_MENU)     ,0,0,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
        addComponent(container,components.get(ComponentHandler.CALCULATOR)    ,0,1,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
        addComponent(container,components.get(ComponentHandler.METRONOME)     ,0,2,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
        addComponent(container,components.get(ComponentHandler.BLOCK_DIAGRAM) ,0,3,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
    }
}
