package FrameComponents.BaseContainer;

import FrameComponents.Container.Container;
import FrameComponents.Functionalities.PinnedMenu.PinnedMenu;
import Service.Interfaces.Card;

import javax.swing.*;
import java.awt.*;

public class BaseContainer implements Card {
    /*
            the very base layer of program
     */

    private CardLayout cardLayout = new CardLayout();
    private PinnedMenu pinnedMenu = new PinnedMenu();//always on top

    private JPanel baseContainer;//holds PinnedMenu and cardContainer

    private JPanel cardContainer;
    //cards inside cardContainer:
    private JPanel mainMenuCard;
    private JPanel calculatorCard;
    private JPanel blockDiagramCard;
    private JPanel metronomeCard;


    public BaseContainer() {
        initComponents();
        setContainerLayout();
        putContentTogether();

        changeContainerColors();
    }

    @Override
    public void initComponents() {
        baseContainer = new Container();
        cardContainer = new Container();

        mainMenuCard = new Container();
        calculatorCard = new Container();
        blockDiagramCard = new Container();
        metronomeCard = new Container();
    }

    @Override
    public void setContainerLayout() {
        baseContainer.setLayout(new BorderLayout());
        cardContainer.setLayout(cardLayout);

        //todo:: set layouts inside all cards, probably all border layout
        metronomeCard.setLayout(new BorderLayout());
        calculatorCard.setLayout(new BorderLayout());
    }

    @Override
    public void putContentTogether() {
        //pinned to the left
        baseContainer.add(pinnedMenu.getContainer(), BorderLayout.WEST); //pinned menu
        baseContainer.add(cardContainer, BorderLayout.CENTER); //current card

        cardContainer.add(mainMenuCard, "main-menu");
        cardContainer.add(calculatorCard, "calculator");
        cardContainer.add(metronomeCard, "metronome");
        cardContainer.add(blockDiagramCard, "block-diagram");
    }

    public PinnedMenu getPinnedMenu() { return pinnedMenu; }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardContainer() { return cardContainer; }

    public JPanel getContainer() { return baseContainer; }

    public JPanel getMetronomeCard() { return metronomeCard; }

    public JPanel getCalculatorCard(){
        return calculatorCard;
    }

    //TODO:: replace colors with graphics?
    private void changeContainerColors() {
        mainMenuCard.setBackground(new Color(100, 0, 0));
        calculatorCard.setBackground(new Color(0, 122, 0));
        blockDiagramCard.setBackground(new Color(11, 200, 255));
        metronomeCard.setBackground(new Color(155, 0, 0));
    }
}
