package Calculator;

import java.awt.*;

class EqualsButton extends CalculatorButton {
    public EqualsButton(String text, Situation situation) {
        super(text, situation);
    }


    @Override
    protected void transition() {
        switch (situation.state) {
            case Input1, OpReady:
                break;
            case HasResult:
                break;
            case Input2:
                int rightOperand = Integer.parseInt(situation.display.getText());
                try {
                    int result = situation.binaryOperator.getOperator().applyAsInt(situation.leftOperand, rightOperand);
                    situation.display.setText(String.valueOf(result));
                } catch (ArithmeticException e) {
                    situation.display.setText("Error..");
                }
                situation.binaryOperator.setColor(Constants.BUTTON_DEFAULT_COLOR);
                situation.state = State.HasResult;
        }
    }
}