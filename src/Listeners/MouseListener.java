package Listeners;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {

    int clicks =0;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicks++;
        System.out.println("\nclicks:" + clicks);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
