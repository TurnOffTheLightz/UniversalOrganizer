package Service.Managment;

import FrameComponents.Button.Button;
import FrameComponents.Container.Container;
import javax.swing.*;
import java.awt.*;

public class ContainerManager {
    //TODO:: bind more containers
    //TODO:: consider List of JPanels instead of single objects
    private ButtonManager buttonManager;

    private JPanel baseContainer = new Container();
    private JPanel cardContainer = new Container();
    private JPanel menuContainer = new Container();
    private JPanel mainMenuContainer = new Container();
    private JPanel calculatorContainer = new Container();
    private JPanel blockDiagramContainer = new Container();
    private JPanel tempoDetectorContainer = new Container();


    public ContainerManager(ButtonManager buttonManager){
        this.buttonManager = buttonManager;
        changeContainerColors();
    }

    //TODO:: maybe paint containers in the future
    public void render() {

    }

    public void addContainersToBaseContainer(){
        baseContainer.add(cardContainer,BorderLayout.CENTER); //current card
        baseContainer.add(menuContainer,BorderLayout.WEST); //pinned menu

        cardContainer.add(mainMenuContainer,"main-menu");
        cardContainer.add(calculatorContainer,"calculator");
        cardContainer.add(tempoDetectorContainer,"tempo-detector");
        cardContainer.add(blockDiagramContainer,"block-diagram");
    }

    void addButtonToMainMenuContainer(Button button, GridBagConstraints gridBagConstraints){
        menuContainer.add(button,gridBagConstraints);
    }

    //TODO:: delete when needed
    private void changeContainerColors(){
        menuContainer.setBackground(new Color(255,0,255));
        mainMenuContainer.setBackground(new Color(100,0,0));
        calculatorContainer.setBackground(new Color(0,122,0));
        blockDiagramContainer.setBackground(new Color(11,200,255));
        tempoDetectorContainer.setBackground(new Color(155,0,0));
    }

    ButtonManager getButtonManager(){
        return buttonManager;
    }

    JPanel getMenuContainer(){ return menuContainer; }

    JPanel getCardContainer(){
        return cardContainer;
    }

    public JPanel getBaseContainer() {
        return baseContainer;
    }

    public JPanel getCalculatorContainer() { return calculatorContainer; }

    public JPanel getTempoDetectorContainer() { return tempoDetectorContainer; }

}
