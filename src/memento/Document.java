package memento;

public class Document {

    private String fontName;
    private String fontSize;
    private String content;

    public String getFontName() {
        return fontName;
    }

    public String getFontSize() {
        return fontSize;
    }

    public String getContent() {
        return content;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DocumentState createDocument(){
        final Document document = new Document();
        document.setContent(content);
        document.setFontSize(fontSize);
        document.setFontName(fontName);
        return new DocumentState(document);
    }

    public void undoDocument(){
        fontName = getFontName();
        fontSize = getFontSize();
        content = getContent();
    }
}
