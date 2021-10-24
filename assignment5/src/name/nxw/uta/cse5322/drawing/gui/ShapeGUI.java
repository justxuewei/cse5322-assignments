package name.nxw.uta.cse5322.drawing.gui;

import name.nxw.uta.cse5322.drawing.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeGUI extends JFrame {

    static int MainPanelHeight = 500;
    static int MainPanelWidth = 1000;
    static int ButtonHeight = 50;
    static int ButtonWidth = 100;

    private final JPanel mainPanel;
    private final JPanel canvas = new JPanel();
    private final JButton boxButton = new JButton("Box");
    private final JButton circleButton = new JButton("Circle");
    private final JButton lineButton = new JButton("Line");
    private final JButton undoButton = new JButton("Undo");
    private final JButton redoButton = new JButton("Redo");

    public ShapeGUI() {
        super();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // main panel
        this.setTitle("Shape Design");
        this.setSize(new Dimension(MainPanelWidth, MainPanelHeight));
        this.setLayout(null);
        mainPanel = (JPanel) this.getContentPane();

        canvas.setBounds(40 + ButtonWidth, 0, MainPanelWidth-60-ButtonWidth, MainPanelHeight);
        canvas.setBackground(Color.WHITE);

        boxButton.setBounds(20, 20, ButtonWidth, ButtonHeight);
        circleButton.setBounds(20, 30 + ButtonHeight, ButtonWidth, ButtonHeight);
        lineButton.setBounds(20, 40 + 2 * ButtonHeight, ButtonWidth, ButtonHeight);
        undoButton.setBounds(20, 50 + 3 * ButtonHeight, ButtonWidth, ButtonHeight);
        redoButton.setBounds(20, 60 + 4 * ButtonHeight, ButtonWidth, ButtonHeight);

        mainPanel.add(canvas);
        mainPanel.add(boxButton);
        mainPanel.add(circleButton);
        mainPanel.add(lineButton);
        mainPanel.add(undoButton);
        mainPanel.add(redoButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public JButton getBoxButton() {
        return boxButton;
    }

    public JButton getCircleButton() {
        return circleButton;
    }

    public JButton getLineButton() {
        return lineButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JButton getRedoButton() {
        return redoButton;
    }
}
