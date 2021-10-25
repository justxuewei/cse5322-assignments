package name.nxw.uta.cse5322.drawing.shape;

import java.awt.*;

public class Circle extends Shape {

    @Override
    public void draw(Graphics g) {
        g.setPaintMode();
        g.setColor(Color.GREEN);
        g.drawOval(getX(), getY(), 100, 100);
    }
}
