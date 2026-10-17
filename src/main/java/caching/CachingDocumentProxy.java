package caching;

import java.util.HashMap;
import java.util.Map;

/**
 * Caching Proxy wrapper intercepting requests to return cached content,
 * eliminating redundant I/O execution.
 */
public class CachingDocumentProxy implements DocumentRepository {

    private final DocumentRepository realDocumentRepository;
    private final Map<String, String> documentCache = new HashMap<>();

    public CachingDocumentProxy(DocumentRepository realDocumentRepository) {
        this.realDocumentRepository = realDocumentRepository;
    }

    @Override
    public String getDocumentContent(String documentId) {
        if (documentCache.containsKey(documentId)) {
            System.out.println("[CachingProxy] CACHE HIT: Returning cached content for '" + documentId + "'");
            return documentCache.get(documentId);
        }

        System.out.println("[CachingProxy] CACHE MISS: Delegating request to real repository for '" + documentId + "'");
        String content = realDocumentRepository.getDocumentContent(documentId);
        documentCache.put(documentId, content);
        return content;
    }
}