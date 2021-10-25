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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PatternController {

    private final ShapeGUI shapeGUI;

    private ShapeEnum currentShape = ShapeEnum.Box;

    // Composite pattern
    private final List<Shape> stack = new ArrayList<>();
    private final List<Shape> redoStack = new ArrayList<>();

    private boolean undoFlag = false;
    private final Undo undo = new Undo();
    private final Redo redo = new Redo();
    private final ClearRedo clearRedo = new ClearRedo();

    private final ActionListener shapeButtonListener = e -> {
        resetRedoStackIfNeeds();

        switch (e.getActionCommand()) {
            case "Box":
                currentShape = ShapeEnum.Box;
                break;
            case "Line":
                currentShape = ShapeEnum.Line;
                break;
            case "Circle":
                currentShape = ShapeEnum.Circle;
                break;
        }
    };

    private final ActionListener undoRedoButtonListener = e -> {
        if (Objects.equals(e.getActionCommand(), "Undo")) {
            if (stack.size() == 0) {
                System.out.println("Undo is not available for now.");
                return;
            }
            this.undoFlag = true;
            undo.execute(stack, redoStack);
        } else {
            if (redoStack.size() == 0) {
                System.out.println("Redo is not available for now.");
                return;
            }
            redo.execute(stack, redoStack);
        }

        rerenderStack();
    };

    public PatternController() {
        this.shapeGUI = new ShapeGUI();
        this.shapeGUI.setVisible(true);
        this.shapeGUI.setBackground(Color.WHITE);
    }

    public void listenEvents() {
        this.shapeGUI.getBoxButton().addActionListener(this.shapeButtonListener);
        this.shapeGUI.getLineButton().addActionListener(this.shapeButtonListener);
        this.shapeGUI.getCircleButton().addActionListener(this.shapeButtonListener);
        this.shapeGUI.getUndoButton().addActionListener(this.undoRedoButtonListener);
        this.shapeGUI.getRedoButton().addActionListener(this.undoRedoButtonListener);

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

    // Iterator pattern is used for rendering graph.
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
