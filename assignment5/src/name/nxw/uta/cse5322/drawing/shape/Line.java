package name.nxw.uta.cse5322.drawing.shape;

import java.awt.*;

public class Line extends Shape {

    @Override
    public void draw(Graphics g) {
        g.setPaintMode();
        g.setColor(Color.BLUE);
        g.drawLine(getX(), getY(), 100, 100);
    }

}
