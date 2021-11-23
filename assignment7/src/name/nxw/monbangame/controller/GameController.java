package name.nxw.monbangame.controller;

import name.nxw.monbangame.context.Context;
import name.nxw.monbangame.gui.GameGUI;
import name.nxw.monbangame.state.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController {

    private final GameGUI gameGUI = new GameGUI();
    private final Context context = new Context(GameGUI.SquareNum);

    private final ActionListener buttonListener = e -> {
        switch (e.getActionCommand()) {
            case "Start":
                new Start(gameGUI).doAction(context);
                break;
            case "End":
                new End(gameGUI).doAction(context);
                break;
        }
    };

    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            switch (e.getKeyCode()) {
                case 37:
                    // go left
                    new GoLeft(gameGUI).doAction(context);
                    break;
                case 38:
                    new GoUp(gameGUI).doAction(context);
                    break;
                case 39:
                    // go right
                    new GoRight(gameGUI).doAction(context);
                    break;
                case 40:
                    // go down
                    new GoDown(gameGUI).doAction(context);
                    break;
            }
        }
    };

    public GameController() {
        gameGUI.setVisible(true);
        gameGUI.setBackground(Color.white);
        gameGUI.setResizable(false);
        gameGUI.getMainPanel().setFocusable(true);
    }

    public void listenEvents() {
        gameGUI.getMainPanel().addKeyListener(keyAdapter);
        gameGUI.getStartButton().addKeyListener(keyAdapter);
        gameGUI.getEndButton().addKeyListener(keyAdapter);
        gameGUI.getStartButton().addActionListener(buttonListener);
        gameGUI.getEndButton().addActionListener(buttonListener);
    }

}
