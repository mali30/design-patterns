package state;

public class SelectionTool implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Selection tool selected");
    }

    @Override
    public void mouseDown() {
        System.out.println("Drawing a dashed rectangle");
    }
}
