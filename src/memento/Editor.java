package memento;

public class Editor {

    private String prevContent;
    private String content;

    public String getContent() {
        return content;
    }

    /**
     * This method allows us to keep track of the previous state
     * @param content the content from the editor
     */
    public void setContent(String content) {
        prevContent = this.content;
        this.content = content;
    }

    public void undo() {
        this.content = this.prevContent;
    }

    /**
     * Will create a new EditorState object to hold the current state
     * @return a new EditorState with the current content
     */
    public EditorState createState() {
        return new EditorState(content);
    }

    /**
     * Resets the state to it's previous
     * @param state the current state
     */
    public void restore(EditorState state) {
        content = state.getContent();
    }
}
