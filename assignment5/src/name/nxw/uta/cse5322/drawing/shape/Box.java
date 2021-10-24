package name.nxw.uta.cse5322.drawing.shape;

import java.awt.*;

public class Box extends Shape {

    @Override
    public void draw(Graphics g) {
        g.setPaintMode();
        g.setColor(Color.RED);
        g.drawRect(getX(), getY(), 100, 100);
    }
}
