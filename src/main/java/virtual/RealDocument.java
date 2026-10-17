package virtual;

public class RealDocument implements Document{
    private final String title;
    private final String filePath;
    private byte[] binaryContent;

    public RealDocument(String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
        downloadFromCloudStorage();
    }

    private void downloadFromCloudStorage() {
        System.out.println("[Cloud Storage] DOWNLOADING heavy binary file for: " + filePath + " (Consuming RAM)...");
        try {
            // Simulate network latency and heavy payload processing
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.binaryContent = new byte[1024 * 1024 * 5]; // 5 MB mock payload
        System.out.println("[Cloud Storage] File successfully loaded into memory.");
    }

    @Override
    public String getTitle() {
        return this.title;
    }


    @Override
    public void download() {
        System.out.println("Processing download stream for document: " + title + " (" + binaryContent.length + " bytes ready).");
    }
}
