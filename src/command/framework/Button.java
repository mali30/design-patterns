package command.framework;

public class Button {

    private String label;
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void click() {
        // delegating or forwarding work to another object. In this case, the command interface
        command.execute();

    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
