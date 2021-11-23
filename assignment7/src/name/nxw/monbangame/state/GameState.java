package name.nxw.monbangame.state;

import name.nxw.monbangame.common.Direction;
import name.nxw.monbangame.context.Context;
import name.nxw.monbangame.gui.GameGUI;

public abstract class GameState implements State {

    private final GameGUI gameGUI;

    public GameState(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    public GameGUI getGameGUI() {
        return gameGUI;
    }

    boolean move(Context context, Direction direction) {
        int x = context.getMonkeyPosition().getX();
        int y = context.getMonkeyPosition().getY();
        switch (direction) {
            case Up:
                context.getMonkeyPosition().setX(Math.max(0, x - 1));
                break;
            case Down:
                context.getMonkeyPosition().setX(Math.min(context.getLimitation(), x + 1));
                break;
            case Left:
                context.getMonkeyPosition().setY(Math.max(0, y - 1));
                break;
            case Right:
                context.getMonkeyPosition().setY(Math.min(context.getLimitation(), y + 1));
        }
        return x != context.getMonkeyPosition().getX() || y != context.getMonkeyPosition().getY();
    }

    boolean isEnded(Context context) {
        return context.getMonkeyPosition() == null ||
                context.getBananaPosition() == null ||
                context.getMonkeyPosition().equals(context.getBananaPosition());
    }

    boolean isWinning(Context context) {
        return context.getMonkeyPosition() != null &&
                context.getBananaPosition() != null &&
                context.getMonkeyPosition().equals(context.getBananaPosition());
    }
}
