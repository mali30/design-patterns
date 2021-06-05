package command.editor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class History {

    private final Deque<UndoableCommand> undoableCommands = new ArrayDeque<>();

    public void push(UndoableCommand command){
        undoableCommands.add(command);
    }

    public UndoableCommand pop() {
        return undoableCommands.pop();
    }
}
