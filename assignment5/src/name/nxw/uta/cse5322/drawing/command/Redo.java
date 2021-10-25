package name.nxw.uta.cse5322.drawing.command;

import name.nxw.uta.cse5322.drawing.shape.Shape;

import java.util.List;

public class Redo implements Command {

    @Override
    public void execute(List<Shape> undoStack, List<Shape> redoStack) {
        Shape last = redoStack.get(redoStack.size() - 1);
        redoStack.remove(redoStack.size() - 1);
        undoStack.add(last);
    }
}
