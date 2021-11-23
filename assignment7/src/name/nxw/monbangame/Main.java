package name.nxw.monbangame;

import name.nxw.monbangame.controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.listenEvents();
    }

}
