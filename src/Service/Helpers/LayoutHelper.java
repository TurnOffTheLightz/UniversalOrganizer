package Service.Helpers;

import java.awt.*;

public class LayoutHelper {


    public GridBagConstraints getGridConstraints(){
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 0;
        gridConstraints.ipady = 0;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

        gridConstraints.weightx = 0.5;
        gridConstraints.weighty = 1.0;
        gridConstraints.insets = new Insets(0,0,0,0);
        gridConstraints.gridy = 0;
        gridConstraints.gridx = 0;
        return gridConstraints;
    }
}
