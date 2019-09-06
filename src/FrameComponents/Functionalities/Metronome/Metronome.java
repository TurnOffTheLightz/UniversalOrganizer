package FrameComponents.Functionalities.Metronome;

import FrameComponents.Button.Button;
import FrameComponents.Container.Container;
import FrameComponents.Functionalities.Functionality;
import Service.Managment.ComponentHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

    /*
    Metronome is a functionality that includes:
    -tempo detecting (~10 clicks, program calculates best matching tempo, prints it and sets to metronome)
    -setting tempo and looping sound as the play button is pressed
    */
public class Metronome extends Functionality {
    /*
           includes:
            protected JPanel container = new Container();

            protected ArrayList<Button> buttons;

            protected LayoutHelper layoutHelper = new LayoutHelper();
     */
    private final int CLICKER = 0;

    //just for metronome
    private TempoDetector tempoDetector = new TempoDetector();

    private JPanel metronomeContainer = new Container();

    private JPanel tempoDetectorContainer = tempoDetector.getContainer();

    private JSlider slider;

    private JLabel label = new JLabel("label");


    public Metronome(){
        initComponents();//implemented
        setContainerLayout();//implemented
        putContentTogether();//implemented

        changeContainerColor();
    }

    public void initComponents() {
        createButtons();//implemented
        createLabels();//labels just for metronome
        createSlider();//slider just for metronome
    }

    public void createButtons(){
        Button playButton = new Button("play", new Color(100, 100, 175));
        Button stopButton = new Button("stop", new Color(100, 100, 175));
        addButton(playButton);
        addButton(stopButton);
        addButton(tempoDetector.getButtons().get(CLICKER));
    }

    //TODO::
    private void createLabels(){
        label.setOpaque(true);
    }

    //TODO::
    private void createSlider(){
        slider = new JSlider(JSlider.HORIZONTAL, 0,300,40);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
    }

    public void setContainerLayout(){
        container.setLayout(new BoxLayout(container,BoxLayout.X_AXIS));
    }

    public void putContentTogether(){
        container.add(tempoDetectorContainer,BoxLayout.X_AXIS);
        container.add(metronomeContainer,BoxLayout.X_AXIS);
        addButtonsToContainers();//implements
    }

    @Override//TODO::set layout for buttons in metronome!
    public void addButtonsToContainers() {
        GridBagConstraints gridConstraints = layoutHelper.getGridConstraints();
        metronomeContainer.add(buttons.get(ComponentHandler.METRONOME_PLAY_BUTTON),gridConstraints);
        metronomeContainer.add(buttons.get(ComponentHandler.METRONOME_STOP_BUTTON),gridConstraints);
    }

    @Override
    public JPanel getContainer() {
        return container;
    }

    @Override
    public ArrayList<Button> getButtons() {
        return buttons;
    }

    private void changeContainerColor(){
        metronomeContainer.setBackground(new Color(150,70,70));
    }

    private class TempoDetector extends Functionality{

        /*
            its like inside metronome. returns container with content straight to Metronome putContentTogether()
         */


        TempoDetector(){
            initComponents();
            setContainerLayout();
            putContentTogether();

            changeContainerColor();
        }

        @Override
        public void initComponents() {
            createButtons();
            createLabels();
        }

        @Override
        public void createButtons() {
            Button clicker = new Button("click me!", new Color(100, 100, 175));
            addButton(clicker);
        }

        //TODO::
        void createLabels() {

        }

        @Override//TODO::
        public void setContainerLayout() {

        }

        @Override
        public void putContentTogether() {
            addButtonsToContainers();
        }

        @Override
        public void addButtonsToContainers() {
            GridBagConstraints gridConstraints = layoutHelper.getGridConstraints();
            container.add(buttons.get(CLICKER), gridConstraints);
        }

        @Override
        public JPanel getContainer() {
            return container;
        }

        @Override
        public ArrayList<Button> getButtons() {
            return buttons;
        }

        private void changeContainerColor(){
            container.setBackground(new Color(180,40,40));
        }
    }
}
