package FrameComponents.Functionalities.Calculator;

import FrameComponents.Button.Button;
import FrameComponents.Functionalities.Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator extends Functionality {

    public static final int CALC_0BUT=0, CALC_1BUT=1,CALC_2BUT=2,CALC_3BUT=3,CALC_4BUT=4,CALC_5BUT=5,CALC_6BUT=6,CALC_7BUT=7,CALC_8BUT=8,CALC_9BUT=9,
            CALC_ADD = 10, CALC_SUBTRACT=11,CALC_MULTIPLY=12,CALC_DIVIDE=13,CALC_POWER=14,CALC_SQRT=15,
            CALC_COMMA=16,CALC_CLEAR=17,CALC_EQUAL=18,CALC_DELETE=19,CALC_OUTPUT=20,CALC_OPERATION=21;

    private CalculatorListener listener = new CalculatorListener();

    private JTextField console = new JTextField(10);

    private JTextArea operationPane = new JTextArea();
    private JScrollPane operationScrollPane = new JScrollPane(operationPane);
    private String operationString = "";

    private ArrayList<Double> numbers = new ArrayList<>();
    private double result;

    private char symbol;

    private boolean isFirstDigit = true;
    private boolean continueCreatingNumber = true;
    private boolean readyForSymbol = true;

    private boolean isAnyComma = false;
    private boolean isCommaLast = false;


    public Calculator(){
        initComponents();
        setContainerLayout();
        putContentTogether();
        //listeners
        addListeners();
        changeContainerColor();
    }

    @Override
    public void initComponents() {
        Button but1 = new Button("1");
        Button but2 = new Button("2");
        Button but3 = new Button("3");
        Button but4 = new Button("4");
        Button but5 = new Button("5");
        Button but6 = new Button("6");
        Button but7 = new Button("7");
        Button but8 = new Button("8");
        Button but9 = new Button("9");
        Button but0 = new Button("0");

        Button addBut = new Button("+");
        Button subtractBut = new Button("-");
        Button multiplyBut = new Button("*");
        Button divideBut = new Button("/");
        Button powerBut = new Button("x^y");
        Button sqrtBut = new Button("root(n)");
        Button commaBut = new Button(",");
        Button clearBut = new Button("C");
        Button equalBut = new Button("=");
        Button deleteBut = new Button("<-");
        console.setText("0");
        console.setHorizontalAlignment(SwingConstants.RIGHT);
        console.setEditable(false);
        operationPane.setEditable(false);
        operationPane.setRows(3);
        operationPane.setLineWrap(true);

        addButtons(but0,but1,but2,but3,but4,but5,but6,  //for buttonList and action listener
                but7,but8,but9,addBut,subtractBut,multiplyBut,
                divideBut,powerBut,sqrtBut,commaBut,clearBut,equalBut,deleteBut);

        addComponents(but0,but1,but2,but3,but4,but5,but6,   //for layout
                but7,but8,but9,addBut,subtractBut,multiplyBut,
                divideBut,powerBut,sqrtBut,commaBut,clearBut,equalBut,deleteBut, console, operationScrollPane);

        setComponentsFont();
    }

    private void setComponentsFont(){
        Font font = new Font("Arial", Font.BOLD, 20);
        for (JComponent comp : components) {
            if(comp instanceof JButton)
                comp.setFont(font);
            else if(comp == console)
                comp.setFont(new Font("Arial", Font.BOLD, 24));
            else if(comp == operationPane)
                comp.setFont(new Font("Arial", Font.BOLD, 14));
        }
    }

    @Override
    public void setContainerLayout() {
        container.setLayout(new GridBagLayout());
    }

    @Override
    public void putContentTogether() {
        layoutHelper.addCalculatorComponents(container,components);
    }

    private void changeContainerColor(){
        container.setBackground(new Color(70,90,180));
    }

    private void addListeners(){
        container.addKeyListener(listener);
        for(JButton b : getButtons()){
            b.addActionListener(listener);
            b.addKeyListener(listener);
        }
    }

    private void addTextToConsole(int number){
        console.setText(console.getText() + number);
    }

    private void addNumberToConsole(int number){
        if(isFirstDigit){
            isFirstDigit = false;
            continueCreatingNumber = true;
            console.setText(String.valueOf(number));
        }else if(continueCreatingNumber){//creating number
            addTextToConsole(number);
            if(isCommaLast) isCommaLast = false;
        }
    }

    private void clear(){
        console.setText("0");
        operationPane.setText("");
        operationString = "";
        clearNumbers();
        isAnyComma = false;
        isCommaLast = false;
        isFirstDigit = true;
        continueCreatingNumber = true;
        readyForSymbol = true;
    }

    private double convertOutputToDouble(){
        return Double.parseDouble(console.getText());
    }

    private void addNumber(double number) {
        numbers.add(number);
    }

    private void clearNumbers(){
        numbers.clear();
    }

    private void clearPanel(){
        operationPane.setText("");
    }

    private void updateSymbol(char sym){
        symbol = sym;
    }

    //::logic::

    //one for all type of operations, they differ just with symbol
    //add,multiply etc..
    private void doOperation(char symbol){
        if(!isCommaLast){
            if(readyForSymbol){
                double currNum = convertOutputToDouble();
                addNumber(currNum);
                addNumberToPanel(currNum);
                addSymbolToPanel(symbol);
                updateSymbol(symbol);
                prepareForNewNumber();
            }else
                changeOperationSymbol(symbol);
        }
    }

    private void prepareForNewNumber(){
        isFirstDigit = true;
        continueCreatingNumber = false;
        readyForSymbol = false;
        isAnyComma = false;
        isCommaLast = false;
        console.setText("0");
    }

    private void equal(){
        if(!isCommaLast)
            if(numbers.size() == 1){
                clearPanel();
                calculate();
                clear();
                printResult();
            }
    }

    private void calculate(){
        if(!numbers.isEmpty()) {
            int lastIndex = numbers.size() - 1;
            double firstNum = numbers.get(lastIndex);
            double secondNum = convertOutputToDouble();

            switch (symbol) {
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if(secondNum == 0) JOptionPane.showMessageDialog(null, "cannot divide by 0!");
                    else result = firstNum / secondNum;
                    break;
                case '^':
                    result = Math.pow(firstNum,secondNum);
                    break;
                case 'r':
                    result =  Math.pow(firstNum,1.0/secondNum);
                    break;
                default:
                    break;
            }
        }
    }

    private void addComma(){
        if(!isAnyComma){
            console.setText(console.getText() + ".");
            isAnyComma = true;
            isCommaLast = true;
        }
    }

    private void backspace(){
        int length = console.getText().length();
        if(length > 0){
            int beginIndex = 0;
            int endIndex = length - 1;
            String tempStr = console.getText();
            tempStr = tempStr.substring(beginIndex,endIndex);
            console.setText(tempStr);
            if(console.getText().equals("")) console.setText("0");
        }
    }

    private void printResult(){
        BigDecimal bd = BigDecimal.valueOf(result);
        bd = bd.stripTrailingZeros();
        console.setText(bd.toPlainString());
    }

    private void changeOperationSymbol(char newSymbol){
        int length = operationString.length();
        if(length>=3){
            int beginIndex = 0;
            int endIndex = length - 3;
            operationString = operationString.substring(beginIndex,endIndex);
            operationString += " " + newSymbol + " ";
            operationPane.setText(operationString);
            updateSymbol(newSymbol);
        }
    }

    private void addNumberToPanel(double num){
        operationString += num;
        operationPane.setText(operationString);
    }

    private void addSymbolToPanel(char symbol){
        if(symbol != 'r') operationString += " " + symbol + " ";
        else operationString += " root ";
        operationPane.setText(operationString);
    }

    private class CalculatorListener implements ActionListener, KeyListener{
        private ArrayList<Integer> keys = new ArrayList<>();
        @Override
        public void keyTyped(KeyEvent e) {
            handleSpecialOperations(e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();
            if(!keys.contains(k)) keys.add(k);

            if(!keys.contains(KeyEvent.VK_SHIFT)){
                handleKeyboardNumbers(k);
                handleKeyboardOperations(k);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int k = e.getKeyCode();
            if(keys.contains(k)) keys.remove((Integer) k);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();

            handleButtonNumbers(obj);
            handleButtonOperations(obj);
        }

        private void handleSpecialOperations(char k){
            if(k == '+') {
                doOperation('+');
            }
            if(k == '*') {
                doOperation('*');
            }
            if(k == '^') {
                doOperation('^');
            }
        }
        private void handleKeyboardOperations(int k){
            if(k == KeyEvent.VK_MINUS) {
                doOperation('-');
            }
            if(k == KeyEvent.VK_SLASH) {
                doOperation('/');
            }
            if(k == KeyEvent.VK_R) {
                doOperation('r');
            }
            if(k == KeyEvent.VK_ENTER){
                equal();
            }
            if(k == KeyEvent.VK_COMMA){
                addComma();
            }
            if(k == KeyEvent.VK_ESCAPE){
                clear();
            }
            if(k == KeyEvent.VK_BACK_SPACE){
                backspace();
            }
        }
        private void handleKeyboardNumbers(int k){
            if(k == KeyEvent.VK_0){
                addNumberToConsole(0);
            }
            if(k == KeyEvent.VK_1){
                addNumberToConsole(1);
            }
            if(k == KeyEvent.VK_2){
                addNumberToConsole(2);
            }
            if(k == KeyEvent.VK_3){
                addNumberToConsole(3);
            }
            if(k == KeyEvent.VK_4){
                addNumberToConsole(4);
            }
            if(k == KeyEvent.VK_5){
                addNumberToConsole(5);
            }
            if(k == KeyEvent.VK_6){
                addNumberToConsole(6);
            }
            if(k == KeyEvent.VK_7){
                addNumberToConsole(7);
            }
            if(k == KeyEvent.VK_8){
                addNumberToConsole(8);
            }
            if(k == KeyEvent.VK_9){
                addNumberToConsole(9);
            }
        }

        private void handleButtonNumbers(Object e){
            if(e == getButtons().get(CALC_0BUT)){
                addNumberToConsole(0);
            }
            if(e == getButtons().get(CALC_1BUT)){
                addNumberToConsole(1);
            }
            if(e == getButtons().get(CALC_2BUT)){
                addNumberToConsole(2);
            }
            if(e == getButtons().get(CALC_3BUT)){
                addNumberToConsole(3);
            }
            if(e == getButtons().get(CALC_4BUT)){
                addNumberToConsole(4);
            }
            if(e == getButtons().get(CALC_5BUT)){
                addNumberToConsole(5);
            }
            if(e == getButtons().get(CALC_6BUT)){
                addNumberToConsole(6);
            }
            if(e == getButtons().get(CALC_7BUT)){
                addNumberToConsole(7);
            }
            if(e == getButtons().get(CALC_8BUT)){
                addNumberToConsole(8);
            }
            if(e == getButtons().get(CALC_9BUT)){
                addNumberToConsole(9);
            }
        }

        private void handleButtonOperations(Object e){
            if (e == getButtons().get(CALC_ADD)) {
                doOperation('+');
            }
            if (e == getButtons().get(CALC_SUBTRACT)) {
                doOperation('-');
            }
            if (e == getButtons().get(CALC_MULTIPLY)) {
                doOperation('*');
            }
            if (e == getButtons().get(CALC_DIVIDE)) {
                doOperation('/');
            }
            if (e == getButtons().get(CALC_POWER)) {
                doOperation('^');
            }
            if (e == getButtons().get(CALC_SQRT)) {
                doOperation('r');
            }
            if(e == getButtons().get(CALC_EQUAL)){
                equal();
            }
            if(e == getButtons().get(CALC_COMMA)){
                addComma();
            }
            if(e == getButtons().get(CALC_CLEAR)){
                clear();
            }
            if(e == getButtons().get(CALC_DELETE)){
                backspace();
            }
        }
    }
}
