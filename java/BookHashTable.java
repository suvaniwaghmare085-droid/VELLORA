/**
 * A small hash table mapping ISBN strings to Book objects.
 * Collision handling: separate chaining with linked nodes.
 */
public class BookHashTable {
    private static class Node {
        String key;
        Book value;
        Node next;
        Node(String key, Book value, Node next) {
            this.key = key; this.value = value; this.next = next;
        }
    }

    private final Node[] buckets;
    private int size;

    public BookHashTable(int capacity) {
        buckets = new Node[Math.max(5, capacity)];
    }

    private int index(String key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    public void put(String isbn, Book book) {
        int i = index(isbn);
        for (Node n = buckets[i]; n != null; n = n.next) {
            if (n.key.equals(isbn)) { n.value = book; return; }
        }
        buckets[i] = new Node(isbn, book, buckets[i]);
        size++;
    }

    public Book get(String isbn) {
        int i = index(isbn);
        for (Node n = buckets[i]; n != null; n = n.next) {
            if (n.key.equals(isbn)) return n.value;
        }
        return null;
    }

    public boolean remove(String isbn) {
        int i = index(isbn);
        Node current = buckets[i], previous = null;
        while (current != null) {
            if (current.key.equals(isbn)) {
                if (previous == null) buckets[i] = current.next;
                else previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public int size() { return size; }
}