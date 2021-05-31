import iterator.BrowseHistory;
import iterator.Iterator;
import memento.Document;
import memento.DocumentHistory;
import memento.DocumentState;
import memento.Editor;
import memento.History;
import state.BrushTool;
import state.Canvas;
import state.SelectionTool;
import strategy.BlackAndWhiteFilter;
import strategy.ImageStorage;
import strategy.JpegCompressor;
import strategy.PngCompressor;
import template.TransferMoneyTask;

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


        /**
         * Iterator pattern
         */
        var browseHistory = new BrowseHistory();
        browseHistory.push("a");
        browseHistory.push("b");
        browseHistory.push("c");

        Iterator iterator = browseHistory.createIterator();
        while(iterator.hasNext()){
            String currentIterator = iterator.current();
            System.out.println(currentIterator);
            iterator.next();
        }

        /*
            Strategy pattern
         */
        var imageStore = new ImageStorage();
        imageStore.store("file1.txt", new JpegCompressor(), new BlackAndWhiteFilter());
        imageStore.store("file2.txt", new PngCompressor(), new BlackAndWhiteFilter());


        /**
         *  Template Method Pattern
         */
        var task = new TransferMoneyTask();
        task.execute();
    }
}
