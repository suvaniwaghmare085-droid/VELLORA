import java.util.HashSet;
import java.util.Set;

/** Uses a HashSet to track ISBNs already seen. */
public class DuplicateBookDetector {
    private final Set<String> isbnSet = new HashSet<>();

    /** Returns true only when the ISBN is new; false means duplicate. */
    public boolean addIfNew(String isbn) {
        if (isbn == null || isbn.isBlank()) return false;
        return isbnSet.add(isbn.trim());
    }

    public boolean contains(String isbn) { return isbnSet.contains(isbn); }
    public int size() { return isbnSet.size(); }
}