package caching;

/**
 * Demonstration runner verifying cache hits and misses execution performance.
 */
public class CachingProxyDemo {
    public static void main(String[] args) {
        DocumentRepository repository = new CachingDocumentProxy(new RealDocumentRepository());

        System.out.println("--- 1. First Access (Cache Miss - Slow Disk Read) ---");
        long start1 = System.currentTimeMillis();
        String doc1 = repository.getDocumentContent("DOC_2026_Q4.pdf");
        System.out.println("Result: " + doc1);
        System.out.println("Execution Time: " + (System.currentTimeMillis() - start1) + " ms\n");

        System.out.println("--- 2. Second Access (Cache Hit - Instant Retrieval) ---");
        long start2 = System.currentTimeMillis();
        String doc1Cached = repository.getDocumentContent("DOC_2026_Q4.pdf");
        System.out.println("Result: " + doc1Cached);
        System.out.println("Execution Time: " + (System.currentTimeMillis() - start2) + " ms\n");

        System.out.println("--- 3. Accessing Different Document (Cache Miss) ---");
        repository.getDocumentContent("ARCHIVE_2025.pdf");
    }
}
