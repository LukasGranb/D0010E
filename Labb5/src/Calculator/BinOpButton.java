package Calculator;

import java.util.function.IntBinaryOperator;

class BinOpButton extends CalculatorButton {
    private final IntBinaryOperator operator;

    public BinOpButton(String text, Situation situation, IntBinaryOperator operator) {
        super(text, situation);
        this.operator = operator;
    }

    @Override
    protected void transition() {
        switch (situation.state) {
            case Input1:
            case HasResult:
                situation.leftOperand = Integer.parseInt(situation.display.getText());
                situation.binaryOperator = this;
                situation.state = State.OpReady;
                setColor(Constants.OPERATOR_SELECTED_COLOR);
                break;
            case OpReady:
                situation.binaryOperator.setColor(Constants.BUTTON_DEFAULT_COLOR);
                situation.binaryOperator = this;
                setColor(Constants.OPERATOR_SELECTED_COLOR);
                break;
        }
    }

    public IntBinaryOperator getOperator() {
        return operator;
    }
}