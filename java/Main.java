public class Main {
    public static void main(String[] args) {
        VelloraManager vellora = new VelloraManager();

        Book alchemist = new Book("9780061122415", "The Alchemist", "Paulo Coelho", 42);
        Book atomic = new Book("9780735211292", "Atomic Habits", "James Clear", 36);
        Book ikigai = new Book("9780143130727", "Ikigai", "Hector Garcia", 29);
        Book pride = new Book("9780141439518", "Pride and Prejudice", "Jane Austen", 24);

        System.out.println("=== VELLORA JAVA DSA DEMONSTRATION ===");

        System.out.println("\\n1. HASH TABLE — ISBN lookup");
        vellora.addBook(alchemist);
        vellora.addBook(atomic);
        vellora.addBook(ikigai);
        vellora.addBook(pride);
        System.out.println("Found: " + vellora.findByIsbn("9780735211292"));

        System.out.println("\\n2. BINARY SEARCH TREE — alphabetical traversal");
        vellora.byTitle.inorder();

        System.out.println("\\n3. QUEUE — FIFO return processing");
        vellora.queueReturn(atomic);
        vellora.queueReturn(ikigai);
        System.out.println("Next return: " + vellora.processNextReturn().getTitle());
        System.out.println("Next return: " + vellora.processNextReturn().getTitle());

        System.out.println("\\n4. MAX HEAP — most requested book");
        Book top = vellora.popularity.peekMax();
        System.out.println("Highest priority: " + top.getTitle() + " (" + top.getRequests() + " requests)");

        System.out.println("\\n5. HASHSET — duplicate ISBN detection");
        Book duplicate = new Book("9780061122415", "Another copy of The Alchemist", "Paulo Coelho", 0);
        System.out.println("Duplicate accepted? " + vellora.addBook(duplicate));
        System.out.println("Unique ISBN count: " + vellora.duplicates.size());

        System.out.println("\\nDemo completed successfully.");
    }
}