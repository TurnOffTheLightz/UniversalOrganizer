package Service.Managment;

import Service.Helpers.FileHelper;

import javax.swing.*;

public class ImageManager {
    /*
    //TODO:: ImageManager contains information about images and their paths, add them
     */

    private final String absolutePath = FileHelper.getAbsolutePath();

    //metronome
    private final static String[] metronomeIconPath = new String[2];
    private static int metronomePos = 0;

    public ImageManager(){
        //metronome
        setMetronomeImages();
    }

    public static ImageIcon getMetronomeIcon(){
        changeMetronomePos();
        return new ImageIcon(metronomeIconPath[metronomePos]);
    }

    private void setMetronomeImages(){
        setMetronomeIconPath();
    }

    private void setMetronomeIconPath(){
        for(int i=0;i<=1;i++){
            metronomeIconPath[i] = absolutePath + "/src/resources/Images/metronome-" + i + ".png";
        }
    }

    private static void changeMetronomePos(){
        if(metronomePos==0) metronomePos=1;
        else if(metronomePos==1) metronomePos =0;
    }
}
