package name.nxw.uta.cse5322.drawing.controller;

import name.nxw.uta.cse5322.drawing.command.ClearRedo;
import name.nxw.uta.cse5322.drawing.command.Redo;
import name.nxw.uta.cse5322.drawing.command.Undo;
import name.nxw.uta.cse5322.drawing.gui.ShapeGUI;
import name.nxw.uta.cse5322.drawing.shape.Box;
import name.nxw.uta.cse5322.drawing.shape.Circle;
import name.nxw.uta.cse5322.drawing.shape.Line;
import name.nxw.uta.cse5322.drawing.shape.Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternController {

    private final ShapeGUI shapeGUI;

    private ShapeEnum currentShape = ShapeEnum.Box;

    private final List<Shape> stack = new ArrayList<>();
    private final List<Shape> redoStack = new ArrayList<>();

    private boolean undoFlag = false;
    private final Undo undo = new Undo();
    private final Redo redo = new Redo();
    private final ClearRedo clearRedo = new ClearRedo();

    public PatternController() {
        this.shapeGUI = new ShapeGUI();
        this.shapeGUI.setVisible(true);
        this.shapeGUI.setBackground(Color.WHITE);
    }

    public void listenEvents() {
        this.shapeGUI.getBoxButton().addActionListener(e -> {
            resetRedoStackIfNeeds();
            currentShape = ShapeEnum.Box;
        });

        this.shapeGUI.getLineButton().addActionListener(e -> {
            resetRedoStackIfNeeds();
            currentShape = ShapeEnum.Line;
        });

        this.shapeGUI.getCircleButton().addActionListener(e -> {
            resetRedoStackIfNeeds();
            currentShape = ShapeEnum.Circle;
        });

        this.shapeGUI.getUndoButton().addActionListener(e -> {
            if (stack.size() == 0) {
                System.out.println("Undo is not available for now.");
                return;
            }
            this.undoFlag = true;

            undo.execute(stack, redoStack);
            rerenderStack();
        });

        this.shapeGUI.getRedoButton().addActionListener(e -> {
            if (redoStack.size() == 0) {
                System.out.println("Redo is not available for now.");
                return;
            }

            redo.execute(stack, redoStack);
            rerenderStack();
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

    private void resetRedoStackIfNeeds() {
        if (this.undoFlag) {
            this.undoFlag = false;
            this.clearRedo.execute(stack, redoStack);
        }
    }

    private void rerenderStack() {
        Graphics g = this.shapeGUI.getCanvas().getGraphics();
        g.clearRect(0, 0, shapeGUI.getCanvas().getWidth(), shapeGUI.getCanvas().getHeight());

        Iterator<Shape> iterator = stack.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            shape.draw(g);
        }
    }

}
