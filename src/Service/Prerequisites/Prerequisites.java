package Service.Prerequisites;

import Service.Helpers.FileHelper;

public class Prerequisites{

    private FileHelper fileHelper;

    public Prerequisites(){

        fileHelper = new FileHelper();
        checkConfigFiles();
    }

    private void checkConfigFiles(){
        fileHelper.checkFolders();
        fileHelper.checkTextFiles();
    }
}
