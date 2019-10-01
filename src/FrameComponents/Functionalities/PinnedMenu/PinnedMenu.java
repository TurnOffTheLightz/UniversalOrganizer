package FrameComponents.Functionalities.PinnedMenu;

import FrameComponents.Button.Button;
import FrameComponents.Functionalities.Functionality;

import java.awt.*;

public class PinnedMenu extends Functionality {

    public static final int MAIN_MENU = 0, CALCULATOR = 1, METRONOME = 2, BLOCK_DIAGRAM = 3;
    /*
        includes:

            protected JPanel container = new Container();

            protected ArrayList<Button> buttons;

            protected ArrayList<JComponent> components = new ArrayList<>();

            protected LayoutHelper layoutHelper = new LayoutHelper();
     */
    // if new button added, do:
            //->initComponents()
            //->layoutHelper.addPinnedMenuComponents(container,components)

    public PinnedMenu(){
        initComponents();
        setContainerLayout();
        putContentTogether();

        changeContainerColor();
    }

    @Override
    public void initComponents() {
        //create
        Button mainMenu = new Button("main-menu",new Color(200,100,50));
        Button calculator = new Button("calculator",new Color(255,0,255));
        Button metronome = new Button("metronome",new Color(150,50,50));
        Button blockDiagram = new Button("block-diagram",new Color(0,255,255));
        //add
        addButtons(mainMenu,calculator,metronome,blockDiagram);
        addComponents(mainMenu,calculator,metronome,blockDiagram);
    }

    @Override
    public void setContainerLayout() {
        container.setLayout(new GridBagLayout());
    }

    @Override
    public void putContentTogether() {
        layoutHelper.addPinnedMenuComponents(container,components);
    }

    private void changeContainerColor(){
        container.setBackground(new Color(69,93,144));
    }
}
