package name.nxw.monbangame.state;

import name.nxw.monbangame.common.Constants;
import name.nxw.monbangame.common.Position;
import name.nxw.monbangame.context.Context;
import name.nxw.monbangame.gui.GameGUI;

public class Start extends GameState {

    public Start(GameGUI gameGUI) {
        super(gameGUI);
    }

    @Override
    public void doAction(Context context) {
        // clear old monkey and banana
        Position monkeyPosition = context.getMonkeyPosition();
        Position bananaPosition = context.getBananaPosition();
        if (monkeyPosition != null) {
            getGameGUI().getSquare(monkeyPosition).setText(null);
        }
        if (bananaPosition != null) {
            getGameGUI().getSquare(bananaPosition).setText(null);
        }

        context.reset();

        // update new monkey and banana
        monkeyPosition = context.getMonkeyPosition();
        bananaPosition = context.getBananaPosition();
        getGameGUI().getSquare(monkeyPosition).setText(Constants.Monkey);
        getGameGUI().getSquare(bananaPosition).setText(Constants.Banana);
    }
}
