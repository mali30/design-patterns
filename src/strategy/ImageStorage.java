package strategy;

public class ImageStorage  {

    /*
        Here we are programming against the interface. That way we can pass different implementations
        based on what classes that implement the interface.
     */

    /**
     * Commented this out since we pass in the Compressor and Filter objects directly vs using a
     * constrcutor. Either way works but second looks cleaner :)
    private Compressor compressor;
    private Filter filter;

    public ImageStorage(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

     */

    public void store(String fileName, Compressor compressor, Filter filter) {
        compressor.compress(fileName);
        filter.apply(fileName);
    }

}
