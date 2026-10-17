package protection;

public class ProtectionProxyDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       PROTECTION PROXY PATTERN - DEMO           ");
        System.out.println("==================================================");

        // 1. Setup users with clear profile identifiers (No personal names)
        User admin = new User("Admin", Role.ADMIN);
        User member = new User("Member", Role.USER);
        User guest = new User("Guest", Role.GUEST);

        // 2. Create documents with different security levels
        Document publicDoc = new ProtectedDocumentProxy(
                "Company_Guidelines.pdf",
                "General rules accessible to everyone.",
                false // Not confidential
        );

        Document confidentialDoc = new ProtectedDocumentProxy(
                "Q4_Financial_Report.pdf",
                "Sensitive financial data restricted from guests.",
                true // Confidential
        );

        // --- SCENARIO 1: Public Document Access ---
        System.out.println("\n--- SCENARIO 1: Public Document ('Company_Guidelines.pdf') ---");

        System.out.println("- Guest tries to download public doc:");
        publicDoc.download(guest); // Should PASS

        System.out.println("\n- Guest tries to delete public doc:");
        publicDoc.delete(guest);   // Should FAIL


        // --- SCENARIO 2: Confidential Document Access ---
        System.out.println("\n--- SCENARIO 2: Confidential Document ('Q4_Financial_Report.pdf') ---");

        System.out.println("- Guest tries to download confidential doc:");
        confidentialDoc.download(guest); // Should FAIL

        System.out.println("\n- Member tries to download confidential doc:");
        confidentialDoc.download(member); // Should PASS


        // --- SCENARIO 3: Deletion Authorization ---
        System.out.println("\n--- SCENARIO 3: Deletion Privileges ---");

        System.out.println("- Member tries to delete confidential doc:");
        confidentialDoc.delete(member); // Should FAIL

        System.out.println("\n- Admin tries to delete confidential doc:");
        confidentialDoc.delete(admin);    // Should PASS

        System.out.println("\n==================================================");
    }
}