package Service.Managment;

import javax.swing.*;

public class ContainerManager {

    private JPanel baseContainer;
    private JPanel mainMenuContainer;

    public ContainerManager(){
        initContainers();
    }

    private void initContainers(){
        createContainers();
        bindContainers();
    }

    private void createContainers(){
        baseContainer = new JPanel();
        mainMenuContainer = new JPanel();
    }
    private void bindContainers(){
        addContainer(baseContainer,mainMenuContainer);
    }

    private void addContainer(JPanel destinationPanel, JPanel originPanel){
        destinationPanel.add(originPanel);
    }

    public JPanel getBaseContainer(){
        return baseContainer;
    }
    public JPanel getMainMenuContainer(){
        return mainMenuContainer;
    }
}
