package name.nxw.uta.cse5322.drawing.command;

import name.nxw.uta.cse5322.drawing.shape.Shape;

import java.util.List;

public class ClearRedo implements Command {

    @Override
    public void execute(List<Shape> undoStack, List<Shape> redoStack) {
        redoStack.clear();
    }
}
