package protection;

public interface Document {
    String getTitle();
    void download(User user);
    void delete(User user);
}
