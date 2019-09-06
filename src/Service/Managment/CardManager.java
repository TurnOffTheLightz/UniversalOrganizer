package Service.Managment;

import FrameComponents.BaseLayer.BaseContainer;
import FrameComponents.Functionalities.Calculator.Calculator;
import FrameComponents.Functionalities.MainMenu.MainMenu;
import FrameComponents.Functionalities.Metronome.Metronome;
import FrameComponents.Functionalities.PinnedMenu.PinnedMenu;
import Service.Helpers.LayoutHelper;
import Service.Interfaces.Menu;
import Service.State.State;

import javax.swing.*;

/*
        creates all the functionalities, swaps cards
 */
public class CardManager implements Menu {
    private BaseContainer baseContainer = new BaseContainer();

    private JPanel cardContainer;

    //classes that extends class Functionality:
    //TODO::
    private Metronome metronome;
    private MainMenu mainMenu;
    private Calculator calculator;

    private LayoutHelper layoutHelper = new LayoutHelper();


    public CardManager(){
        createFunctionalities();
        putContentTogether();
        swapCard("main-menu");
    }


    private void createFunctionalities(){
        metronome = new Metronome();
    }

    private void putContentTogether(){
        setCardContainer();
        baseContainer.getMetronomeCard().add(metronome.getContainer(),layoutHelper.getGridConstraints());
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

    /*
           getFunctionality methods:
     */
    PinnedMenu getPinnedMenu() {
        return baseContainer.getPinnedMenu();
    }

    Metronome getMetronome() {
        return metronome;
    }

    //in future
    public Calculator getCalculator() {
        return calculator;
    }

}
