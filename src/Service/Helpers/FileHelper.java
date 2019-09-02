package Service.Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper {

    private final String contentFolderPath = getAbsolutePath() + "/Universal Organizer Files";

    //TODO:: consider ArrayList of Files instead of single File objects
    //folders
    private File contentFolder = new File(contentFolderPath);
    private File tempoDetectorFolder = new File(contentFolderPath + "/Tempo-Detector");
    private File blockDiagram = new File(contentFolderPath + "/Block-Diagram");
    //text files
    private File readme = new File(contentFolderPath + "/README.txt");
    private File organizerConfig = new File(contentFolderPath + "/Organizer-Config.txt");
    private File tempoDetectorConfig = new File(tempoDetectorFolder +"/TempoDetector-Config.txt");

    private PrintWriter printWriter;

    private DateHelper dateHelper;

    public FileHelper(){
        dateHelper = new DateHelper();
    }
    private String getAbsolutePath(){
        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath().toString();
        /*
        another way to do this
        return System.getProperty("user.dir");
         */
    }
    public void checkFolders(){
        if(!contentFolder.exists()){
            createFolder(contentFolder);
        }
        if(!tempoDetectorFolder.exists()){
            createFolder(tempoDetectorFolder);
        }
        if(!blockDiagram.exists()){
            createFolder(blockDiagram);
        }
    }
    public void checkTextFiles(){
        if(!organizerConfig.exists()){
            createTextFile(organizerConfig);
        }
        if(!readme.exists()){
            createReadme();
        }
        if(!tempoDetectorConfig.exists()){
            createTextFile(tempoDetectorConfig);
        }
    }

    private void createFolder(File file){
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }
    private void createReadme() {
        createTextFile(readme);
        openPrintWriter(readme);
        addReadmeText();
        closePrintWriter();
    }
    private void addReadmeText(){
        addLineToFile(readme, "__Universal Organizer__ first open " + dateHelper.getCurrentDate());
        addLineToFile(readme, "");
        addLineToFile(readme, "__Universal Organizer__ is an app which aims to:");
        addLineToFile(readme, "\t-help you organize your daily routine or week plan");
        addLineToFile(readme,"\t-plan and name segments during songwriting process, featuring one-clip records");
        addLineToFile(readme, "\t-include block-diagram maker feature - for clearer and faster programming process");
        addLineToFile(readme, "\t-include tempo-detector-on-taps feature");
        addLineToFile(readme, "");
        addLineToFile(readme, "");
        addLineToFile(readme, "\t\tCreated by Miron Oskroba git\t->\thttps://github.com/TurnOffTheLightz");
    }
    private void createTextFile(File file){
        openPrintWriter(file);
        addLineToFile(file,"Example config file message","CREATED-CONFIG-FILE");
        closePrintWriter();
    }

    private void addLineToFile(File file, final String text, final String infoType){
        addTextToPrintWriter("id" + "->" +infoType + "->" + text);
    }

    private void addLineToFile(File file, final String text){
        addTextToPrintWriter(text);
    }

    private void openPrintWriter(File file){
        try {
            printWriter = new PrintWriter(file,"UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void closePrintWriter(){
        printWriter.close();
    }

    private void addTextToPrintWriter(final String text){
        printWriter.println(text);
    }
    /*
            DateHelper class gives current date as string
     */
    private class DateHelper{

        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        private Date date = new Date(System.currentTimeMillis());

        private String getCurrentDate(){
            return formatter.format(date);
        }
    }
}
