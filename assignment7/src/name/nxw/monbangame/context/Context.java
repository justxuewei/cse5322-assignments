package name.nxw.monbangame.context;

import name.nxw.monbangame.common.Direction;
import name.nxw.monbangame.common.Position;

import java.util.Random;

public class Context {

    private Position monkeyPosition;
    private Position bananaPosition;

    private final int limitation;

    public Context(int limitation) {
        this.limitation = limitation;
    }

    public void reset() {
        Random rand = new Random(System.currentTimeMillis());
        do {
            monkeyPosition = new Position(rand.nextInt(limitation), rand.nextInt(limitation));
            bananaPosition = new Position(rand.nextInt(limitation), rand.nextInt(limitation));
        } while (monkeyPosition.equals(bananaPosition));
    }

    public Position getMonkeyPosition() {
        return monkeyPosition;
    }

    public void setMonkeyPosition(Position monkeyPosition) {
        this.monkeyPosition = monkeyPosition;
    }

    public Position getBananaPosition() {
        return bananaPosition;
    }

    public void setBananaPosition(Position bananaPosition) {
        this.bananaPosition = bananaPosition;
    }

    public int getLimitation() {
        return limitation;
    }
}
