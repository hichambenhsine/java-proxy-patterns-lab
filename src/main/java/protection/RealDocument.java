package protection;

public class RealDocument implements Document {
    private final String title;
    private final String content;

    public RealDocument(String title, String content) {
        this.title = title;
        this.content = content;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void download(User user) {
        System.out.println("[SUCCESS] Document '" + title + "' downloaded by user: " + user.getUsername());
    }

    @Override
    public void delete(User user) {
        System.out.println("[SUCCESS] Document '" + title + "' PERMANENTLY DELETED by admin: " + user.getUsername());
    }
}
