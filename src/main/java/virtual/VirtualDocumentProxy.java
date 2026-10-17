package virtual;

public class VirtualDocumentProxy implements Document{
    private final String title;
    private final String filePath;
    private RealDocument realDocument;

    public VirtualDocumentProxy(String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void download() {
        if(realDocument == null){
            System.out.println("[Proxy] First download request detected. Initializing RealDocument...");
            realDocument = new RealDocument(title, filePath);
        } else {
            System.out.println("[Proxy] RealDocument already exists. Reusing cached instance.");
        }
        realDocument.download();
    }
}
