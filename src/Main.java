import memento.Document;
import memento.DocumentHistory;
import memento.DocumentState;
import memento.Editor;
import memento.History;
import state.BrushTool;
import state.Canvas;
import state.SelectionTool;

public class Main {

    public static void main(String[] args) {

        /**
         * Memento pattern
         */
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        history.push(editor.createState());
        editor.undo();

        System.out.println(editor.getContent());

        var document = new Document();
        document.setFontName("Bold");
        document.setFontSize("10px");
        document.setContent("content");

        var documentState = new DocumentState(document);
        var documentHistory = new DocumentHistory();

        documentHistory.addDocument(documentState);
        documentHistory.removeLastDocument();

        System.out.println(document.getContent());

        /**
         * State pattern
         */
        var canvas = new Canvas();
        canvas.setTool(new BrushTool());
        canvas.mouseUp();
        canvas.mouseDown();

        canvas.setTool(new SelectionTool());
        canvas.mouseUp();
        canvas.mouseDown();


    }
}
