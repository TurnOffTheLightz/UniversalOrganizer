package Service.State;

public enum State {     mainMenu,calculator,tempoDetector,blockDiagram;

    public static State state;

    public static void setStateFromString(String string){
        if(string.equals("main-menu")) state = mainMenu;
        else if(string.equals("calculator")) state = calculator;
        else if(string.equals("tempo-detector")) state = tempoDetector;
        else if(string.equals("block-diagram")) state = blockDiagram;
     }

    public static boolean mainMenuOpen(){ return state == mainMenu; }

    public static boolean calculatorOpen(){
        return state == calculator;
    }

    public static boolean tempoDetectorOpen(){
        return state == tempoDetector;
    }

    public static boolean blockDiagramOpen(){
        return state == blockDiagram;
    }

};
