package name.nxw.uta.cse5322.drawing.command;

import name.nxw.uta.cse5322.drawing.shape.Shape;

import java.util.List;

public class Undo implements Command {

    @Override
    public void execute(List<Shape> undoStack, List<Shape> redoStack) {
        Shape last = undoStack.get(undoStack.size() - 1);
        undoStack.remove(undoStack.size() - 1);
        redoStack.add(last);
    }
}
