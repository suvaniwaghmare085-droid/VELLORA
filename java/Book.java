public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private int requests;

    public Book(String isbn, String title, String author, int requests) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.requests = requests;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getRequests() { return requests; }
    public void addRequest() { requests++; }

    @Override
    public String toString() {
        return title + " by " + author + " [ISBN: " + isbn + ", requests: " + requests + "]";
    }
}