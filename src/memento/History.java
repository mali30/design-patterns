package memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    /**
     * The history of states
     */
    private List<EditorState> states = new ArrayList<>();

    /**
     * Will add a new editorState object to the list
     * @param editorState the editorState object containing the content
     */
    public void push(EditorState editorState){
        states.add(editorState);
    }

    /**
     * Will remove the last editorState object from the list
     * @return returns the last editor state object
     */
    public EditorState pop(){
        var lastIndex = states.size() - 1;
        var lastState = states.get(lastIndex);
        states.remove(lastState);

        return lastState;
    }

}
