import command.AddCustomerCommand;
import command.BlackAndWhiteCommand;
import command.CompositeCommands;
import command.CustomerService;
import command.ResizeCommand;
import command.editor.BoldCommand;
import command.editor.HTMLDocument;
import command.editor.UndoableCommand;
import command.framework.Button;
import command.framework.Command;
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
import template.GenerateReportTask;
import template.Task;
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
        Task task  = new TransferMoneyTask();
        task.execute();

        task = new GenerateReportTask();
        task.execute();

        /**
         *  Command pattern
         */
        CustomerService customerService = new CustomerService();
        Command command = new AddCustomerCommand(customerService);
        Button button = new Button(command);
        button.click();

        CompositeCommands compositeCommands = new CompositeCommands();
        Command command1 = new BlackAndWhiteCommand();
        Command command2 = new ResizeCommand();
        compositeCommands.addCommand(command);
        compositeCommands.addCommand(command1);
        compositeCommands.addCommand(command2);

        compositeCommands.printCommands();

        command.editor.History history1 = new command.editor.History();
        HTMLDocument htmlDocument = new HTMLDocument();

        htmlDocument.setContent("Hello world");
        UndoableCommand boldCommand = new BoldCommand(htmlDocument, history1);
        boldCommand.execute();
        System.out.println(htmlDocument.getContent());
        // another option is to make an UndoCommand class where you pass in the history as a
        // parameter and call history.pop.unexeute()
        boldCommand.unexecute();
        System.out.println(htmlDocument.getContent());



    }
}
