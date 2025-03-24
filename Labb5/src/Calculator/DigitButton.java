package Calculator;

class DigitButton extends CalculatorButton {
    private final int digit;

    public DigitButton(String text, Situation situation) {
        super(text, situation);
        this.digit = Integer.parseInt(text);
    }

    @Override
    protected void transition() {
        switch (situation.state) {
            case Input1, Input2:
                String currentText = situation.display.getText();
                if (currentText.equals("0")) {
                    situation.display.setText(String.valueOf(digit));
                } else {
                    situation.display.setText(currentText + digit);
                }
                break;
            case OpReady:
                situation.display.setText(String.valueOf(digit));
                situation.state = State.Input2;
                break;
            case HasResult:
                situation.display.setText(String.valueOf(digit));
                situation.state = State.Input1;
                break;
        }
    }
}