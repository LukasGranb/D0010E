package Calculator;

import javax.swing.*;

class Situation {
    State state = State.Input1;
    JLabel display;
    BinOpButton binaryOperator;
    int leftOperand;


    Situation(JLabel display){
        this.leftOperand = 0;
        this.display = display;
    }
}