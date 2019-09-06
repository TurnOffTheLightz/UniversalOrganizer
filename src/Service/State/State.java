package Service.State;

public enum State {

    mainMenu,calculator, metronome,blockDiagram;

    public static State state;

    public static void setStateFromString(String string){
        switch (string) {
            case "main-menu":
                state = mainMenu;
                break;
            case "calculator":
                state = calculator;
                break;
            case "metronome":
                state = metronome;
                break;
            case "block-diagram":
                state = blockDiagram;
                break;
            default:
                break;
        }
     }

    public static boolean mainMenuOpen(){ return state == mainMenu; }

    public static boolean calculatorOpen(){
        return state == calculator;
    }

    public static boolean metronomeOpen(){
        return state == metronome;
    }

    public static boolean blockDiagramOpen(){
        return state == blockDiagram;
    }

};
