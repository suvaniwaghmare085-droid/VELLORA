/** Binary Search Tree ordered alphabetically by book title. */
public class BookBST {
    private static class Node {
        Book book;
        Node left, right;
        Node(Book book) { this.book = book; }
    }

    private Node root;

    public void insert(Book book) { root = insert(root, book); }

    private Node insert(Node node, Book book) {
        if (node == null) return new Node(book);
        int comparison = book.getTitle().compareToIgnoreCase(node.book.getTitle());
        if (comparison < 0) node.left = insert(node.left, book);
        else if (comparison > 0) node.right = insert(node.right, book);
        return node;
    }

    public Book search(String title) {
        Node current = root;
        while (current != null) {
            int comparison = title.compareToIgnoreCase(current.book.getTitle());
            if (comparison == 0) return current.book;
            current = comparison < 0 ? current.left : current.right;
        }
        return null;
    }

    public void inorder() { inorder(root); }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println("  " + node.book.getTitle());
        inorder(node.right);
    }
}