package name.nxw.uta.cse5322.drawing.controller;

import name.nxw.uta.cse5322.drawing.gui.ShapeGUI;
import name.nxw.uta.cse5322.drawing.shape.Box;
import name.nxw.uta.cse5322.drawing.shape.Circle;
import name.nxw.uta.cse5322.drawing.shape.Line;
import name.nxw.uta.cse5322.drawing.shape.Shape;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PatternController {

    private final ShapeGUI shapeGUI;

    private ShapeEnum currentShape = ShapeEnum.Box;

    private final ArrayList<Shape> stack = new ArrayList<>();
    private final ArrayList<Shape> redoStack = new ArrayList<>();

    public PatternController() {
        this.shapeGUI = new ShapeGUI();
        this.shapeGUI.setVisible(true);
        this.shapeGUI.setBackground(Color.WHITE);
    }

    public void listenClickEvent() {
        this.shapeGUI.getBoxButton().addActionListener(e -> {
            currentShape = ShapeEnum.Box;
        });

        this.shapeGUI.getLineButton().addActionListener(e -> {
            currentShape = ShapeEnum.Line;
        });

        this.shapeGUI.getCircleButton().addActionListener(e -> {
            currentShape = ShapeEnum.Circle;
        });

        this.shapeGUI.getCanvas().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

                Graphics g = shapeGUI.getCanvas().getGraphics();

                Shape newShape;
                if (currentShape == ShapeEnum.Box) {
                    newShape = new Box();
                } else if (currentShape == ShapeEnum.Line) {
                    newShape = new Line();
                } else {
                    newShape = new Circle();
                }

                newShape.setX(e.getX());
                newShape.setY(e.getY());
                newShape.draw(g);
                stack.add(newShape);
            }
        });
    }

}

enum ShapeEnum {
    Circle,
    Line,
    Box,
}
