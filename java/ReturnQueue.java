/** Array-backed circular FIFO queue for returned books. */
public class ReturnQueue {
    private final Book[] items;
    private int front = 0, rear = 0, size = 0;

    public ReturnQueue(int capacity) { items = new Book[Math.max(2, capacity)]; }

    public boolean enqueue(Book book) {
        if (size == items.length) return false;
        items[rear] = book;
        rear = (rear + 1) % items.length;
        size++;
        return true;
    }

    public Book dequeue() {
        if (size == 0) return null;
        Book result = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size--;
        return result;
    }

    public Book peek() { return size == 0 ? null : items[front]; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}