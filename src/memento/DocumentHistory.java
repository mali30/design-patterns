package memento;

import java.util.ArrayList;
import java.util.List;

public class DocumentHistory {

    private final List<DocumentState> documentState = new ArrayList<>();

    public void addDocument(DocumentState documentToAdd){
        documentState.add(documentToAdd);
    }

    public void removeLastDocument(){
        int lastDocument = documentState.size() - 1;
        documentState.remove(lastDocument);

    }
}
