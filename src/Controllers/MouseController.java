package Controllers;

import java.awt.event.MouseEvent;

public class MouseController implements java.awt.event.MouseListener {
    //TODO:: bind "add text area" button on mouse press
    //TODO:: create class ButtonHelper, it gonna help with button bounds containing mouse (x,y) to check if the button was pressed
    public static int mousePressX;
    public static int mousePressY;
    public static boolean mousePressed = false;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setPressed();
        savePosition(e);
        printPosition();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        printPosition();
        setPressed();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void setPressed(){
        mousePressed = !mousePressed;
    }

    private void savePosition(MouseEvent e){
        mousePressX = e.getX();
        mousePressY = e.getY();
    }
    private void printPosition(){
        System.out.println("(x,y) = " + "("+mousePressX + ","+mousePressY+")");
    }
}
