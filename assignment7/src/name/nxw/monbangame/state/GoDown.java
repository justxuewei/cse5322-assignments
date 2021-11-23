package name.nxw.monbangame.state;

import name.nxw.monbangame.common.Constants;
import name.nxw.monbangame.common.Direction;
import name.nxw.monbangame.common.Position;
import name.nxw.monbangame.context.Context;
import name.nxw.monbangame.gui.GameGUI;

public class GoDown extends GameState {

    public GoDown(GameGUI gameGUI) {
        super(gameGUI);
    }

    @Override
    public void doAction(Context context) {
        if (isEnded(context)) {
            return;
        }

        Position oldMonkeyPosition = context.getMonkeyPosition().copy();

        if (move(context, Direction.Down)) {
            getGameGUI().getSquare(oldMonkeyPosition).setText(null);

            if (isWinning(context)) {
                getGameGUI().getSquare(context.getBananaPosition()).setText(Constants.Winning);
            } else {
                getGameGUI().getSquare(context.getMonkeyPosition()).setText(Constants.Monkey);
            }
        }
    }
}
