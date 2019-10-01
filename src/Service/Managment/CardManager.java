package Service.Managment;

import FrameComponents.BaseContainer.BaseContainer;
import FrameComponents.Functionalities.Calculator.Calculator;
import FrameComponents.Functionalities.Metronome.Metronome;
import FrameComponents.Functionalities.PinnedMenu.PinnedMenu;
import FrameComponents.Helpers.LayoutHelper;
import Service.Interfaces.Menu;
import Service.State.State;

import javax.swing.*;
import java.awt.*;

/*
        handles functionalities, swaps cards
 */
public class CardManager implements Menu {
    private ComponentHandler componentHandler = new ComponentHandler(this);

    private LayoutHelper layoutHelper = new LayoutHelper();

    private BaseContainer baseContainer = new BaseContainer();

    private JPanel cardContainer;
    /*
        //TODO:: more functionalities
     */
    private Metronome metronome;
    private Calculator calculator;


    public CardManager(){
        metronome = new Metronome();
        calculator = new Calculator();

        putContentTogether();
        swapCard("main-menu");
    }

    private void putContentTogether(){
        setCardContainer();
        baseContainer.getMetronomeCard().add(metronome.getContainer(),BorderLayout.CENTER);
        baseContainer.getCalculatorCard().add(calculator.getContainer(),BorderLayout.CENTER);
    }

    private void setCardContainer(){
        this.cardContainer = baseContainer.getCardContainer();
    }

    public void swapCard(String swapTo){
        baseContainer.getCardLayout().show(cardContainer,swapTo);
        State.setStateFromString(swapTo);
    }

    public JPanel getContainer(){
        return baseContainer.getContainer();
    }

    public ComponentHandler getComponentHandler(){
        return componentHandler;
    }

    /*
           getFunctionality methods:
     */
    PinnedMenu getPinnedMenu() {
        return baseContainer.getPinnedMenu();
    }

    public Metronome getMetronome() {
        return metronome;
    }

}
