package name.nxw.monbangame.state;

import name.nxw.monbangame.context.Context;
import name.nxw.monbangame.gui.GameGUI;

public class End extends GameState {

    public End(GameGUI gameGUI) {
        super(gameGUI);
    }

    @Override
    public void doAction(Context context) {
        if (context.getBananaPosition() != null) {
            getGameGUI().getSquare(context.getBananaPosition()).setText(null);
            context.setBananaPosition(null);
        }
        if (context.getMonkeyPosition() != null) {
            getGameGUI().getSquare(context.getMonkeyPosition()).setText(null);
            context.setMonkeyPosition(null);
        }
    }
}
