package Calculator;

import java.awt.*;

class CancelButton extends CalculatorButton {
    public CancelButton(String text, Situation situation) {
        super(text, situation);
    }

    @Override
    protected void transition() {
        situation.display.setText("0");
        situation.state = State.Input1;
        if (situation.binaryOperator != null) {
            situation.binaryOperator.setColor(Constants.BUTTON_DEFAULT_COLOR);
        }
    }
}