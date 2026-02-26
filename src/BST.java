import java.util.NoSuchElementException;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> parent = null;
    private int size = 0;

    /**
     * @param value is added to BST using addRec()
     */
    public void add(E value){
        size++;
        if (parent == null) {
            parent = new TreeNode<E>(value, null, null);
            return;
        }
        TreeNode<E> node = parent;
        TreeNode<E> newV = new TreeNode<E>(value, null, null);
        addRec(parent, value);
    }

    /**
     * @param value is the value searched for by containRec()
     * @return the output of containRec
     */
    public boolean contains(E value){
        return containRec(parent, value);
    }

    /**
     * @return the amount of nodes in BST
     */
    public int countNodes(){
        return size;
    }

    /**
     * @return the amount of lead nodes in BST using countLeafRec()
     */
    public int countLeafNodes(){
        return countLeafRec(parent);
    }

    /**
     * @return returns the height of BST using countHeight()
     */
    public int getHeight(){
        return countHeight(parent);
    }

    /**
     * @return a string of the BST in order using printIn()
     */
    public String printInorder(){
        if (parent == null) {
            return null;
        }
        return("[" + printIn(parent) + "]");
    }

    /**
     * @return a string of the BST in preorder format using printPre()
     */
    public String printPreorder(){
        if (parent == null)
            return null;
        String print = printPre(parent);
        return("[" + print.substring(0,print.length()-2) + "]");
    }

    /**
     * @return a string of the BST in postorder format using printPost()
     */
    public String printPostorder(){
        if (parent == null)
            return null;
        return("[" + printPost(parent) + "]");
    }

    /**
     * @param value to remove from BST
     * @return the deleted value using deleteRec()
     * @throws NoSuchElementException if the element doesn't exist in BST
     */
    public E delete(E value) throws NoSuchElementException{
        return deleteRec(value, parent);
    }

    /**
     * Clears the tree
     */
    public void clearTree(){parent = new TreeNode<>(null, null, null);}

    /**
     * @param root is the node to start at
     * @param value is the value added
     */
    private void addRec(TreeNode<E> root, E value){
        TreeNode<E> v = new TreeNode<>(value, null, null);

        if (root.compareTo(v) >= 0){
            if (root.getLeftChild() == null){
                root.setLeftChild(v);
            }
            else{
                addRec(root.getLeftChild(), value);
            }
        }
        else if (root.compareTo(v) < 0){
            if (root.getRightChild() == null){
                root.setRightChild(v);
            }
            else{
                addRec(root.getRightChild(), value);
            }
        }
    }

    /**
     * @param node is the starting node
     * @param value is the value to find
     * @return true is BST contains value, false otherwise
     */
    private boolean containRec(TreeNode<E> node, E value){
        if (node == null)
            return false;

        TreeNode<E> left = node.getLeftChild();
        TreeNode<E> right = node.getRightChild();
        TreeNode<E> v = new TreeNode<>(value, null, null);
        int compareL = -100;
        int compareR = -100;
        if (node.getLeftChild() != null)
            compareL = left.compareTo(v);
        if (node.getRightChild() != null)
            compareR = right.compareTo(v);
        int compare = node.compareTo(v);
        if (compare == 0 || compareL == 0 || compareR == 0)
            return true;
        else if (compare > 0 && node.getLeftChild() != null){
            return containRec(node.getLeftChild(), value);
        }
        else if (compare < 0 && node.getRightChild() != null){
            return containRec(node.getRightChild(), value);
        }
        return false;
    }

    /**
     * @param node is the starting node
     * @return the amount of leaf nodes
     */
    private int countLeafRec(TreeNode<E> node){
        if (node == null)
            return 0;
        if (node.getLeftChild() == null && node.getRightChild() == null)
            return 1;
        return countLeafRec(node.getLeftChild()) + countLeafRec(node.getRightChild());
    }

    /**
     * @param node is the stating node
     * @return the height of BST
     */
    private int countHeight(TreeNode<E> node) {
        int maxCountL = 1;
        int maxCountR = 1;
        if (node == null)
            return 0;
        if (node.getLeftChild() != null)
            maxCountL = 1 + countHeight(node.getLeftChild());
        if (node.getRightChild() != null)
            maxCountR = 1 + countHeight(node.getRightChild());

        return Math.max(maxCountL, maxCountR);
    }

    /**
     * @param node is the stating node
     * @return a string of the nodes of BST inorder
     */
    private String printIn(TreeNode<E> node){
        String output = node.getValue() + "";

        if (node.getLeftChild() != null) {
            output = printIn(node.getLeftChild()) + ", " + output;
        }
        if (node.getRightChild() != null) {
            output += ", ";
            output += printIn(node.getRightChild());
        }

        return output;
    }

    /**
     * @param node is the stating node
     * @return a string of the nodes of BST in preorder format
     */
    private String printPre(TreeNode<E> node){
        String output = node.getValue() + ", ";

        if (node.getLeftChild() != null){
            output += printPre(node.getLeftChild());
        }
        if (node.getRightChild() != null){
            output += printPre(node.getRightChild());
        }
        return output;
    }

    /**
     * @param node is the stating node
     * @return a string of the nodes of BST in postorder format
     */
    private String printPost(TreeNode<E> node){
        String output = node.getValue() + "";
        if (node.getRightChild() != null) {
            output = printPost(node.getRightChild()) + ", " + output;
        }
        if (node.getLeftChild() != null){
            output = printPost(node.getLeftChild()) + ", " + output;
        }
        return output;
    }

    /**
     * @param value is the value to delete from BST
     * @param node is the stating node
     * @return the value delete
     * @throws NoSuchElementException if value is not in BST
     */
    private E deleteRec(E value, TreeNode<E> node) throws NoSuchElementException {
        if (node == null || !contains(value))
            throw new NoSuchElementException();
        TreeNode<E> left = node.getLeftChild();
        TreeNode<E> right = node.getRightChild();
        TreeNode<E> v = new TreeNode<>(value, null, null);
        int compareL = left.compareTo(v);
        int compareR = right.compareTo(v);
        int compare = node.compareTo(v);
        if (compareL == 0){
            node.setLeftChild(left.getLeftChild());
            return value;
        }
        else if (compareR == 0){
            node.setRightChild(right.getRightChild());
            return value;
        }
        else if (compare > 0){
            return deleteRec(value, node.getLeftChild());
        }

        else if (compare < 0)
            return deleteRec(value, node.getRightChild());
        else {
            String a = this.printIn(right);
            String[] b = a.split(" ");
            for (String string : b) {
                this.addRec(left, (E) string);
            }
            parent = left;
            return value;
        }
    }
}
