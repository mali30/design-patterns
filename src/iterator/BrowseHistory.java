package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BrowseHistory {

//    private List<String> urls = new ArrayList<>();
//    private Stack<String> urls = new Stack<>();

    private String[] urls = new String[10];
    private int count;

//    public void push(String url){
//        urls.add(url);
//    }

    private void pushArray(String url){
        urls[count++] = url;
    }

//    public String pop(){
//        return urls.remove(urls.size()-1);
//    }
//
    public String popArray(){
        return urls[--count];
    }

//    public List<String> getUrls() {
//        return urls;
//    }

//    public Iterator createIterator() {
//        return new ListIterator(this);
//    }

    public Iterator createIterator() {
        return new ArrayIterator(this);
    }
//
//    public static class ListIterator implements Iterator {
//
//        private BrowseHistory history;
//        private int index;
//
//        public ListIterator(BrowseHistory history){
//            this.history = history;
//        }
//
//        @Override
//        public void next() {
//            index++;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return (index < history.urls.size());
//        }
//
//        @Override
//        public String current() {
//            return history.getUrls().get(index);
//        }
//    }

    public static class ArrayIterator implements Iterator{

        private BrowseHistory browseHistory;
        private int index;

        public ArrayIterator(BrowseHistory browseHistory){
            this.browseHistory = browseHistory;
        }

        @Override
        public void next() {
            index++;
        }

        @Override
        public boolean hasNext() {
            return index < browseHistory.count;
        }

        @Override
        public String current() {
            return browseHistory.urls[index];
        }
    }
}
