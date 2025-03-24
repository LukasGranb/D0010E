package Calculator;

import javax.swing.*;
import java.awt.*;

public abstract class CalculatorButton extends JButton {
    protected Situation situation;

    public CalculatorButton(String text, Situation situation) {
        super(text);
        this.situation = situation;

        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
        setFont(new Font("Arial", Font.BOLD, Constants.FONT_SIZE));

        addActionListener(e -> transition());
    }

    protected abstract void transition();

    public void setColor(Color color) {
        setBackground(color);
    }

    @Override
    public String toString() {
        return getText();
    }
}