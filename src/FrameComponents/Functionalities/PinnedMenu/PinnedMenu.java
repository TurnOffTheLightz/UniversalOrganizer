package FrameComponents.Functionalities.PinnedMenu;

import FrameComponents.Button.Button;
import FrameComponents.Functionalities.Functionality;
import Service.Managment.ComponentHandler;

import java.awt.*;

public class PinnedMenu extends Functionality {
    /*
        includes:

            protected JPanel container = new Container();

            protected ArrayList<Button> buttons;

            protected LayoutHelper layoutHelper = new LayoutHelper();
     */

    //just for pinned menu


    public PinnedMenu(){
        initComponents();
        setContainerLayout();
        putContentTogether();

        changeContainerColor();
    }

    @Override
    public void initComponents() {
        createButtons();
    }

    @Override
    public void createButtons() {
        Button mainMenu = new Button("main-menu",new Color(200,100,50));
        Button calculator = new Button("calculator",new Color(255,0,255));
        Button metronome = new Button("metronome",new Color(150,50,50));
        Button blockDiagram = new Button("block-diagram",new Color(0,255,255));
        addButton(mainMenu);
        addButton(calculator);
        addButton(metronome);
        addButton(blockDiagram);
    }

    @Override
    public void setContainerLayout() {
        container.setLayout(new GridBagLayout());
    }

    @Override
    public void putContentTogether() {
        addButtonsToContainers();
    }

    @Override
    public void addButtonsToContainers() {
        GridBagConstraints gridConstraints = layoutHelper.getGridConstraints();

        container.add(buttons.get(ComponentHandler.MAIN_MENU), gridConstraints);
        gridConstraints.gridy = 1;
        container.add(buttons.get(ComponentHandler.CALCULATOR), gridConstraints);
        gridConstraints.gridy = 2;
        container.add(buttons.get(ComponentHandler.METRONOME), gridConstraints);
        gridConstraints.gridy = 3;
        container.add(buttons.get(ComponentHandler.BLOCK_DIAGRAM), gridConstraints);
    }

    @Override
    protected void addButton(Button button){
        super.addButton(button);
    }

    private void changeContainerColor(){
        container.setBackground(new Color(255,0,255));
    }
}
