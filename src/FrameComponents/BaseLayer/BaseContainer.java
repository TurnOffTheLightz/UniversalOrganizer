package FrameComponents.BaseLayer;

import FrameComponents.Container.Container;
import FrameComponents.Functionalities.PinnedMenu.PinnedMenu;
import Service.Interfaces.Card;

import javax.swing.*;
import java.awt.*;

public class BaseContainer implements Card {

    private CardLayout cardLayout = new CardLayout();
    private PinnedMenu pinnedMenu = new PinnedMenu();

    private JPanel baseContainer;
    private JPanel cardContainer;

    private JPanel mainMenuCard;
    private JPanel calculatorCard;
    private JPanel blockDiagramCard;
    private JPanel metronomeCard;


    public BaseContainer(){
        initComponents();
        setContainerLayout();
        putContentTogether();

        changeContainerColors();
    }

    @Override
    public void initComponents() {
        createContainers();
    }

    private void createContainers(){
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
        metronomeCard.setLayout(new GridBagLayout());
    }

    @Override
    public void putContentTogether() {
        //TODO:: pinned menu to the left
        baseContainer.add(pinnedMenu.getContainer(),BorderLayout.WEST); //pinned menu
        baseContainer.add(cardContainer,BorderLayout.CENTER); //current card

        cardContainer.add(mainMenuCard,"main-menu");
        cardContainer.add(calculatorCard,"calculator");
        cardContainer.add(metronomeCard,"metronome");
        cardContainer.add(blockDiagramCard,"block-diagram");
    }

    public PinnedMenu getPinnedMenu(){
        return pinnedMenu;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardContainer(){
        return cardContainer;
    }

    public JPanel getContainer(){
        return baseContainer;
    }

    public JPanel getMetronomeCard(){
        return metronomeCard;
    }

    //TODO:: replace graphics, copied from ContainerManager class
    private void changeContainerColors(){
        mainMenuCard.setBackground(new Color(100,0,0));
        calculatorCard.setBackground(new Color(0,122,0));
        blockDiagramCard.setBackground(new Color(11,200,255));
        metronomeCard.setBackground(new Color(155,0,0));
    }

    //unused
    @Override
    public void addButtonsToContainers() {

    }
    @Override
    public void createButtons() {

    }
}
