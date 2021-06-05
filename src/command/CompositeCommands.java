package command;

import command.framework.Command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommands {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command){
        commands.add(command);
    }

    public void printCommands() {
        for(Command command : commands){
            command.execute();
        }
    }



}
