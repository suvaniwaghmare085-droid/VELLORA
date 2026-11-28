/** Coordinates the core data structures used by VELLORA. */
public class VelloraManager {
    public final BookHashTable byIsbn = new BookHashTable(31);
    public final BookBST byTitle = new BookBST();
    public final ReturnQueue returns = new ReturnQueue(50);
    public final PopularityMaxHeap popularity = new PopularityMaxHeap(100);
    public final DuplicateBookDetector duplicates = new DuplicateBookDetector();

    public boolean addBook(Book book) {
        if (!duplicates.addIfNew(book.getIsbn())) return false;
        byIsbn.put(book.getIsbn(), book);
        byTitle.insert(book);
        popularity.insert(book);
        return true;
    }

    public Book findByIsbn(String isbn) { return byIsbn.get(isbn); }
    public boolean queueReturn(Book book) { return returns.enqueue(book); }
    public Book processNextReturn() { return returns.dequeue(); }
}