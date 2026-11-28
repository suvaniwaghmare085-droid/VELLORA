/** Max Heap where the book with the highest request count is at the root. */
public class PopularityMaxHeap {
    private final Book[] heap;
    private int size;

    public PopularityMaxHeap(int capacity) { heap = new Book[Math.max(2, capacity)]; }

    public boolean insert(Book book) {
        if (size == heap.length) return false;
        heap[size] = book;
        int child = size++;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (heap[parent].getRequests() >= heap[child].getRequests()) break;
            swap(parent, child);
            child = parent;
        }
        return true;
    }

    public Book peekMax() { return size == 0 ? null : heap[0]; }

    public Book extractMax() {
        if (size == 0) return null;
        Book max = heap[0];
        heap[0] = heap[--size];
        heap[size] = null;
        heapify(0);
        return max;
    }

    private void heapify(int parent) {
        while (true) {
            int largest = parent, left = 2 * parent + 1, right = 2 * parent + 2;
            if (left < size && heap[left].getRequests() > heap[largest].getRequests()) largest = left;
            if (right < size && heap[right].getRequests() > heap[largest].getRequests()) largest = right;
            if (largest == parent) return;
            swap(parent, largest);
            parent = largest;
        }
    }

    private void swap(int a, int b) {
        Book temp = heap[a]; heap[a] = heap[b]; heap[b] = temp;
    }

    public int size() { return size; }
}