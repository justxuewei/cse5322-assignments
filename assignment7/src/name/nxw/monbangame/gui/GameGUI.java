package name.nxw.monbangame.gui;

import name.nxw.monbangame.common.Position;
import name.nxw.monbangame.component.SquarePanel;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {

    static int MainPanelHeight = 530;
    static int MainPanelWidth = 750;
    static int ButtonHeight = 50;
    static int ButtonWidth = 100;
    static int ButtonMargin = 10;
    public static int SquareNum = 10;

    private final JPanel mainPanel;
    private final SquarePanel[][] squares;
    private final JButton startButton, endButton;

    public GameGUI() {
        super();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // main panel
        setTitle("Monkey Banana");
        setSize(new Dimension(MainPanelWidth, MainPanelHeight));
        setLayout(null);
        mainPanel = (JPanel) this.getContentPane();

        JPanel squaresPanel = new JPanel();
        int spWidth = MainPanelWidth - 40 - ButtonWidth;
        int spHeight = MainPanelHeight - 30;
        squaresPanel.setBounds(40 + ButtonWidth, 0, spWidth, spHeight);
        squaresPanel.setBackground(Color.RED);
        squaresPanel.setLayout(null);

        squares = new SquarePanel[SquareNum][SquareNum];
        int sX = 0, sY = 0;
        int sWidth = spWidth / SquareNum, sHeight = spHeight / SquareNum;
        for (int i = 0; i < SquareNum; i++) {
            for (int j = 0; j < SquareNum; j++) {
                SquarePanel s = new SquarePanel("");
                // add the current square to squaresPanel
                squaresPanel.add(s);
                s.setBounds(sX, sY, sWidth, sHeight);
                // update sX to avoid overlaying
                sX += sWidth;
                // background color
                if ((i + j) % 2 == 0) {
                    s.setBackground(Color.lightGray);
                } else {
                    s.setBackground(Color.white);
                }
                squares[i][j] = s;
            }
            // reset sX and update sY for the new line
            sX = 0;
            sY += sHeight;
        }

        int buttonX = 20, buttonY = 20;
        startButton = new JButton("Start");
        startButton.setBounds(buttonX, buttonY, ButtonWidth, ButtonHeight);
        buttonY += ButtonMargin + ButtonHeight;
        endButton = new JButton("End");
        endButton.setBounds(buttonX, buttonY, ButtonWidth, ButtonHeight);

        mainPanel.add(startButton);
        mainPanel.add(endButton);
        mainPanel.add(squaresPanel);
    }

    public SquarePanel getSquare(Position position) {
        if (position.getX() < 0 || position.getX() >= SquareNum ||
                position.getY() < 0 || position.getY() >= SquareNum) {
            return null;
        }
        return squares[position.getX()][position.getY()];
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getEndButton() {
        return endButton;
    }
}
