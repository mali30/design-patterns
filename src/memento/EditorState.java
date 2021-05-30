package Memento;

public class EditorState {

    /**
     * The list of content
     */
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
