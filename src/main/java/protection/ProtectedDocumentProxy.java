package protection;

public class ProtectedDocumentProxy implements Document{
    private final RealDocument realDocument;
    private final boolean isConfidential;

    public ProtectedDocumentProxy(String title, String content, boolean isConfidential) {
        this.realDocument = new RealDocument(title, content);
        this.isConfidential = isConfidential;
    }

    @Override
    public String getTitle() {
        return realDocument.getTitle();
    }

    @Override
    public void download(User user) {
        if(isConfidential && user.getRole() == Role.GUEST){
            System.out.println("[ACCESS DENIED] User '" + user.getUsername() + "' (GUEST) cannot download confidential document: " + realDocument.getTitle());
            return;
        }
        System.out.println("[Proxy] Access granted for download to user: " + user.getUsername());
        realDocument.download(user);
    }

    @Override
    public void delete(User user) {
        if(user.getRole() != Role.ADMIN){
            System.out.println("[ACCESS DENIED] User '" + user.getUsername() + "' (" + user.getRole() + ") is NOT authorized to delete document: " + realDocument.getTitle());
            return;
        }
        System.out.println("[Proxy] Access granted for deletion to admin: " + user.getUsername());
        realDocument.delete(user);
    }
}
