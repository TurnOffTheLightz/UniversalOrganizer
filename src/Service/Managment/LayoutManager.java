package Service.Managment;

import Service.State.State;
import java.awt.*;

public class LayoutManager {
    //TODO:: set GridBagLayout for calculatorContainter

    private ContainerManager containerManager;

    private CardLayout cardLayout = new CardLayout();

    public LayoutManager(ContainerManager containerManager){
        this.containerManager = containerManager;
        setContainerLayouts();
        swapCard("main-menu");
    }

    public void swapCard(String swapTo){
        cardLayout.show(containerManager.getCardContainer(),swapTo);
        State.setStateFromString(swapTo);
    }

    public void addButtons(){
        addMenuButtons();
    }

    private void addMenuButtons(){
        GridBagConstraints gridConstraints = getGridConstraints();

        containerManager.addButtonToMainMenuContainer(containerManager.getButtonManager().getMenuButtons().get(ButtonManager.MAIN_MENU),gridConstraints);
        gridConstraints.gridy = 1;
        containerManager.addButtonToMainMenuContainer(containerManager.getButtonManager().getMenuButtons().get(ButtonManager.CALCULATOR),gridConstraints);//calculator
        gridConstraints.gridy = 2;
        containerManager.addButtonToMainMenuContainer(containerManager.getButtonManager().getMenuButtons().get(ButtonManager.TEMPO_DETECTOR),gridConstraints);//tempo detector
        gridConstraints.gridy = 3;
        containerManager.addButtonToMainMenuContainer(containerManager.getButtonManager().getMenuButtons().get(ButtonManager.BLOCK_DIAGRAM),gridConstraints);//block diagram
    }

    private GridBagConstraints getGridConstraints(){
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 0;
        gridConstraints.ipady = 0;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(0,0,0,0);
        gridConstraints.gridy = 0;
        return gridConstraints;
    }

    private void setContainerLayouts(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        containerManager.getMenuContainer().setLayout(gridBagLayout);
        containerManager.getBaseContainer().setLayout(new BorderLayout());
        containerManager.getCardContainer().setLayout(cardLayout);
    }
}
