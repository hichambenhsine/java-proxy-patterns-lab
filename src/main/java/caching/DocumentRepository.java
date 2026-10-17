package caching;

/**
 * Subject interface defining document retrieval contract.
 */
public interface DocumentRepository {
    String getDocumentContent(String documentId);
}