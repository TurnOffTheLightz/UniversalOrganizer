package Listeners;

import Service.Helpers.ActionHelper;

import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {

    private ActionHelper actionHelper;

    public ActionListener(ActionHelper actionHelper){
        this.actionHelper = actionHelper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionHelper.actionPerformed(e);
    }
}
