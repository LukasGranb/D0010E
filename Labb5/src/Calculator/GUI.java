package Calculator;

import javax.swing.*;
import java.awt.*;
import Calculator.Constants;

public class GUI extends JFrame {
    private final Situation situation;
    private final JPanel canvas;
    private final JPanel keypad;
    private final JLabel display;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Miniräknare");

        canvas = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);

        display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        display.setFont(new Font("Arial", Font.BOLD, Constants.FONT_SIZE));
        display.setBackground(Constants.DISPLAY_BG_COLOR);
        display.setOpaque(true);

        display.setPreferredSize(new Dimension(this.getWidth(), Constants.DISPLAY_HEIGHT));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = Constants.GRID_SIZE;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = Constants.DISPLAY_WEIGHT_X;
        gbc.weighty = Constants.DISPLAY_WEIGHT_Y;
        canvas.add(display, gbc);

        situation = new Situation(display);

        keypad = new JPanel(new GridLayout(Constants.GRID_SIZE, Constants.GRID_SIZE));

        String buttonLabels [] = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "=", "C", "+"
        };

        for (String label : buttonLabels) {
            CalculatorButton button;
            switch (label) {
                case "+":
                    button = new BinOpButton(label, situation, (a, b) -> a + b);
                    break;
                case "-":
                    button = new BinOpButton(label, situation, (a, b) -> a - b);
                    break;
                case "*":
                    button = new BinOpButton(label, situation, (a, b) -> a * b);
                    break;
                case "/":
                    button = new BinOpButton(label, situation, (a, b) -> a / b);
                    break;
                case "=":
                    button = new EqualsButton(label, situation);
                    break;
                case "C":
                    button = new CancelButton(label, situation);
                    break;
                default:
                    button = new DigitButton(label, situation);
                    break;
            }
            keypad.add(button);
        }

        gbc.gridy = 1;
        canvas.add(keypad, gbc);

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}