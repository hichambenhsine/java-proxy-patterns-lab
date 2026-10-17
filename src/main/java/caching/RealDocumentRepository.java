package caching;

/**
 * Concrete Subject representing heavy disk or database operations.
 */
public class RealDocumentRepository implements DocumentRepository {

    @Override
    public String getDocumentContent(String documentId) {
        System.out.println("[RealDocumentRepository] Reading document '" + documentId + "' from file system / database...");
        try {
            // Simulate heavy I/O latency (2 seconds)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Content of document: " + documentId;
    }
}