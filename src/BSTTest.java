import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @org.junit.jupiter.api.Test
    void add() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        assertEquals("[100]", bst.printInorder());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertTrue(bst.contains(30));
    }

    @org.junit.jupiter.api.Test
    void countNodes() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertEquals(7, bst.countNodes());
    }

    @org.junit.jupiter.api.Test
    void countLeafNodes() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertEquals(4, bst.countLeafNodes());
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertEquals(3, bst.getHeight());
    }

    @org.junit.jupiter.api.Test
    void printInorder() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertEquals("[10, 20, 30, 100, 150, 200, 300]", bst.printInorder());
    }

    @org.junit.jupiter.api.Test
    void printPreorder() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertEquals("[100, 20, 10, 30, 200, 150, 300]", bst.printPreorder());
    }

    @org.junit.jupiter.api.Test
    void printPostorder() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        assertEquals("[10, 30, 20, 150, 300, 200, 100]", bst.printPostorder());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        bst.delete(300);
        assertEquals("[10, 20, 30, 100, 150, 200]", bst.printInorder());
    }

    @org.junit.jupiter.api.Test
    void clearTree() {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(20);
        bst.add(10);
        bst.add(200);
        bst.add(30);
        bst.add(300);
        bst.add(150);
        bst.clearTree();
        assertEquals("[null]", bst.printInorder());
    }
}