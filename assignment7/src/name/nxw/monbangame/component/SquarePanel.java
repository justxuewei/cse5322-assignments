package name.nxw.monbangame.component;

import javax.swing.*;

public class SquarePanel extends JPanel {

    private final JLabel label;

    public SquarePanel(String text) {
        label = new JLabel(text);
        add(label);
    }

    public void setText(String text) {
        label.setText(text);
    }

}
