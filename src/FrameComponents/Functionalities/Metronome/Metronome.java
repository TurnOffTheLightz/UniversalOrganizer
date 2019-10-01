package FrameComponents.Functionalities.Metronome;

import FrameComponents.Button.Button;
import FrameComponents.Functionalities.Functionality;
import Service.Helpers.FileHelper;
import Service.Managment.ImageManager;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
        Metronome is a functionality that includes:
        -tempo detecting (~10 clicks, program calculates best matching tempo, prints it and sets to metronome)
        -setting tempo and looping sound as the play button is pressed
        -animation as the tempo resolves
*/
public class Metronome extends Functionality {
    //TODO:: add nice 400x550px metronome graphics, background to panel and buttons

    public static final int METRONOME_PLAY_BUTTON = 0, METRONOME_STOP_BUTTON = 1, METRONOME_CLICKER_BUTTON =2,
            METRONOME_SLIDER = 3, METRONOME_TEXTFIELD = 4, METRONOME_IMAGE_LABEL = 5, METRONOME_RADIO_BOX = 6;
    public static final int METRONOME_RADIO_2 = 0, METRONOME_RADIO_3 = 1, METRONOME_RADIO_4 = 2;
    /*
           extend includes:
            protected JPanel container = new Container();

            protected ArrayList<Button> buttons;

            protected LayoutHelper layoutHelper = new LayoutHelper();

            protected ArrayList<JComponent> components = new ArrayList<>();
     */
    //components:
    private JSlider slider;
    private JTextField textField;
    private JLabel imgLabel;

    private Box radioBox = Box.createHorizontalBox();
    private JRadioButton radioButton2 = createRadioButton("2");
    private JRadioButton radioButton3 = createRadioButton("3");
    private JRadioButton radioButton4 = createRadioButton("4");
    private ButtonGroup radioGroup = new ButtonGroup();
    //when adding new, create new final int in layoutHelper and set its layout

    //sound
    private Audio audio = new Audio();
    //tempodetector - clicker
    private TempoDetector tempoDetector = new TempoDetector();

    public Metronome(){
        initComponents();//implemented
        setContainerLayout();//implemented
        putContentTogether();//implemented

        changeContainerColor();
    }

    public void initComponents() {
        //create
        Button playButton = new Button("play", new Color(100, 100, 144));
        Button stopButton = new Button("stop", new Color(100, 100, 144));
        Button clicker = new Button("15 clicks to detect tempo!", new Color(100,100,255));
        this.textField = createTextField();
        this.slider = createSlider();
        this.imgLabel = createLabel();
        //radio buttons
        radioGroup.add(radioButton2);
        radioGroup.add(radioButton3);
        radioGroup.add(radioButton4);

        radioBox.add(radioButton2);
        radioBox.add(radioButton3);
        radioBox.add(radioButton4);
        //add
        addButtons(playButton,stopButton,clicker);
        addComponents(playButton,stopButton,clicker,slider,textField,imgLabel,radioBox);
    }

    private JSlider createSlider(){
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0,300,100);
        slider.setSize(new Dimension(250,50));
        slider.setMajorTickSpacing(10);
        slider.setFont(new Font("Arial", Font.BOLD, 8));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }

    private JRadioButton createRadioButton(String s){
        return new JRadioButton(s);
    }

    private JTextField createTextField(){
        JTextField textField = new JTextField(10);
        textField.setText("100");
        return textField;
    }

    private JLabel createLabel(){
        return new JLabel(ImageManager.getMetronomeIcon());
    }

    public void setContainerLayout(){
        container.setLayout(new GridBagLayout());
    }

    public void putContentTogether(){
        layoutHelper.addMetronomeComponents(container,components);
    }

    //components
    public JSlider getSlider(){ return slider;}
    public JTextField getTextField(){ return textField;}
    public ArrayList<JRadioButton> getRadioButtons(){
        ArrayList <JRadioButton> buttons = new ArrayList<>();
        buttons.add(radioButton2);
        buttons.add(radioButton3);
        buttons.add(radioButton4);
        return buttons;
    }

    //Graphics
    private void changeContainerColor(){
        container.setBackground(new Color(69,90,144));
    }

    //SOUND.
    public synchronized void startTicking() {
        audio.start();
    }
    public synchronized void stopTicking(){
        audio.stop();
    }

    //radio buttons
    public void setKlackValue(int value){
        audio.klackValue = value - 1;
    }

    //clicker
    public void updateClicker(){
        tempoDetector.update();
    }

            /*
                    TEMPO DETECTOR
                    calculates intervals between clicks and set them to slider and textfield
             */
    private class TempoDetector{
        private boolean readyToCalc = false;
        long now;
        private long lastTime;
        private double ns = 1000000000.0;
        private int intervalIterator = 0;
        private int preIterator = 0;
        private double[] intervals = new double[10];
        private int sliderValue;

        void update(){
            if(intervalIterator == 9){
                setTempo();
                reset();
            }
            if(readyToCalc) calcTime();
            prepareCalc();
        }
        private void prepareCalc(){
            if(preIterator>=4){
                readyToCalc = true;
                return;
            }
            now = System.nanoTime();
            lastTime = now;
            preIterator++;
        }
        private void calcTime(){
            now = System.nanoTime();
            intervals[intervalIterator] = (now-lastTime)/ns;
            lastTime = now;
            intervalIterator++;
        }
        private void setTempo(){
            calcSliderValue();
            textField.setText(Double.toString(sliderValue));
            slider.setValue(sliderValue);
            JOptionPane.showMessageDialog(null,"Tempo set to: " + sliderValue);
        }
        private void calcSliderValue(){
            double frequency,sum=0;
            for(double d : intervals){
                sum += d;
            }
            frequency = sum/10.0;
            sliderValue = (int)(60.0/frequency);
        }
        private void reset(){
            intervalIterator = 0;
            preIterator = 0;
            readyToCalc = false;
        }
    }
            /*
                    metronome AUDIO class plays sound
             */
    private class Audio  implements LineListener {
        private final File klackBaseFile = FileHelper.klackBaseFile;
        private final File klackNiceFile = FileHelper.klackNiceFile;

        private Thread soundThread;
        private boolean playing;
        private int klackIterator = 0;
        private int klackValue = 3;

        JDialog playingDialog;
        Clip clip;

        synchronized void start(){
                    if(playing) stop();
                    playing = true;
                    soundThread = new Thread(new SoundThread(slider.getValue()));
                    soundThread.start();
                }
        synchronized void stop(){
                    if(!playing) return;
                    playing = false;
                    klackIterator = 0;
                    try {
                        soundThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        void playSound() {
            try {
                Line.Info linfo = new Line.Info(Clip.class);
                Line line = null;
                line = AudioSystem.getLine(linfo);

                clip = (Clip) line;
                clip.addLineListener(this);
                AudioInputStream ais = getAudio();
                clip.open(ais);
                clip.start();
            }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) { e.printStackTrace(); }
        }

        private AudioInputStream getAudio() throws IOException, UnsupportedAudioFileException {
            if(klackIterator == klackValue){
                klackIterator = 0;
                return AudioSystem.getAudioInputStream(klackNiceFile);
            }
            klackIterator++;
            return AudioSystem.getAudioInputStream(klackBaseFile);
        }

        @Override
        public void update(LineEvent event) {
            LineEvent.Type type = event.getType();
            if (type == LineEvent.Type.OPEN) {
            } else if (type == LineEvent.Type.CLOSE) {
                System.exit(0);
            } else if (type == LineEvent.Type.START) {
                playingDialog.setVisible(true);
            } else if (type == LineEvent.Type.STOP) {
                playingDialog.setVisible(false);
                clip.close();
            }
        }
        /*
                    creates thread for current ticking-session
             */
        private class SoundThread implements Runnable{
            private TempoCalculator tempoCalculator;

            private SoundThread(int sliderValue){
                tempoCalculator = new TempoCalculator(sliderValue);
            }

            @Override
            public void run() {
                while(playing){
                    tempoCalculator.calcTime();
                    if(tempoCalculator.ready()){
                        audio.playSound();
                        imgLabel.setIcon(ImageManager.getMetronomeIcon());
                        tempoCalculator.reset();
                    }
                }
            }
            /*
                    calculates when to play sound
             */
            private class TempoCalculator {
                private long lastTime = System.nanoTime();
                private double delta = 0.0;
                private double ns = 1000000000.0;
                private double frequency;

                private TempoCalculator(int sliderValue){
                    frequency = getFrequency(sliderValue);
                }

                private double getFrequency(int sliderValue){
                    return 60.0/sliderValue;
                }

                void calcTime(){
                    long now = System.nanoTime();
                    delta+=(now-lastTime)/ns;
                    lastTime = now;
                }

                boolean ready() {
                    return delta>=frequency;
                }

                void reset(){
                    delta = 0;
                }
            }
        }
    }
}
