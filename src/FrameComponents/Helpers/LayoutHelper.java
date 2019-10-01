package FrameComponents.Helpers;

import FrameComponents.Functionalities.Calculator.Calculator;
import FrameComponents.Functionalities.Metronome.Metronome;
import FrameComponents.Functionalities.PinnedMenu.PinnedMenu;
import Service.Managment.ComponentHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LayoutHelper {
    /*
            helps to deal with layouts, much of them
     */

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
        addComponent(container,components.get(Metronome.METRONOME_SLIDER),        0,0,4,1,1,0,0,0,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        addComponent(container,components.get(Metronome.METRONOME_PLAY_BUTTON),   0,1,2,1,1,1,0,25,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL);
        addComponent(container,components.get(Metronome.METRONOME_STOP_BUTTON),   1,1,2,1,1,1,0,25,GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL);
        addComponent(container,components.get(Metronome.METRONOME_TEXTFIELD),     0,2,1,1,1,50,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        addComponent(container,components.get(Metronome.METRONOME_CLICKER_BUTTON),2,2,2,2,1,1,0,0,GridBagConstraints.SOUTHEAST,GridBagConstraints.BOTH);
        addComponent(container,components.get(Metronome.METRONOME_IMAGE_LABEL),   0,3,1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        addComponent(container,components.get(Metronome.METRONOME_RADIO_BOX),     0,2,1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE);
    }

    public void addPinnedMenuComponents(JPanel container, ArrayList<JComponent> components){
        addComponent(container,components.get(PinnedMenu.MAIN_MENU)     ,0,0,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
        addComponent(container,components.get(PinnedMenu.CALCULATOR)    ,0,1,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
        addComponent(container,components.get(PinnedMenu.METRONOME)     ,0,2,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
        addComponent(container,components.get(PinnedMenu.BLOCK_DIAGRAM) ,0,3,1,1,1,1,0,0,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH);
    }

    public void addCalculatorComponents(JPanel container, ArrayList<JComponent> components){
        addComponent(container,components.get(Calculator.CALC_0BUT),    0,8,4,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_1BUT),    0,6,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_2BUT),    2,6,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_3BUT),    4,6,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_4BUT),    0,4,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_5BUT),    2,4,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_6BUT),    4,4,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_7BUT),    0,2,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_8BUT),    2,2,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_9BUT),    4,2,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_ADD),     6,8,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_SUBTRACT),6,6,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_MULTIPLY),6,4,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_DIVIDE),  6,2,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_POWER),   8,2,4,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_SQRT),    8,4,4,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_COMMA),   4,8,2,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_EQUAL),   8,6,4,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_CLEAR),   0,0,2,1,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_OUTPUT),  2,0,8,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_OPERATION),10,0,2,2,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.BOTH);
        addComponent(container,components.get(Calculator.CALC_DELETE),  0,1,2,1,1,1,0,0,GridBagConstraints.SOUTH,GridBagConstraints.BOTH);
    }
}
