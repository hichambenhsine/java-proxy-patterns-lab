package virtual;

public class VirtualProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== SCENARIO: Loading a list of documents in a UI ===");

        Document doc1 = new VirtualDocumentProxy("Invoice_2026_Q1.pdf", "s3://bucket/invoices/q1.pdf");
        Document doc2 = new VirtualDocumentProxy("Contract_Client_X.pdf", "s3://bucket/contracts/x.pdf");

        System.out.println("\n-> UI renders document titles instantly:");
        System.out.println("- " + doc1.getTitle());
        System.out.println("- " + doc2.getTitle());
        System.out.println("\n[Notice: Zero network traffic or heavy loading occurred while listing titles]\n");

        System.out.println("=== SCENARIO: User clicks to download 'Invoice_2026_Q1.pdf' ===");
        doc1.download(); // Triggers heavy download for doc1 only

        System.out.println("\n=== SCENARIO: User clicks a second time on the same invoice ===");
        doc1.download(); // Reuses the already loaded instance instantly
    }
}