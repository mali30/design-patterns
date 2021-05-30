package state;

public class Canvas{

    /**
     * This class has two methods which will be called based on the kind of object that gets passed.
     * We have two classes implementing the interface so based on which kind of Tool, we get different implementations.
     * This is the state pattern.
     */

    private Tool tool;

    public void mouseDown() {
        tool.mouseDown();
    }

    public void mouseUp() {
        tool.mouseUp();
    }

    public Tool getToolType(){
        return tool;
    }

    public void setTool(Tool tool){
        this.tool = tool;
    }
}
