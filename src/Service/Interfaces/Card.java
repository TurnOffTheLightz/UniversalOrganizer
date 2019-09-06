package Service.Interfaces;

public interface Card {
    /*
        classes that implement this interface mostly need following methods
     */
    void initComponents();
    void createButtons();
    void setContainerLayout();
    void putContentTogether();

    //it can happen that class dont need buttons, but need all other methods
    void addButtonsToContainers();
}
