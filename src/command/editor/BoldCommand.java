package command.editor;

public class BoldCommand implements UndoableCommand {

    private String prevContent;
    private HTMLDocument htmlDocument;
    private History history;

    public BoldCommand(HTMLDocument htmlDocument, History history) {
        this.htmlDocument = htmlDocument;
        this.history = history;
    }

    @Override
    public void unexecute() {
        htmlDocument.setContent(prevContent);
    }

    @Override
    public void execute() {
        prevContent = htmlDocument.getContent();
        htmlDocument.makeBold();
        history.push(this);

    }
}
