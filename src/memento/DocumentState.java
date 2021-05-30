package memento;

public class DocumentState {

    public DocumentState(Document document) {
        String fontName = document.getFontName();
        String fontSize = document.getFontSize();
        String content = document.getContent();
    }
}
