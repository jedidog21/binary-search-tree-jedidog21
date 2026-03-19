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
        if (!containRec(parent, value)) {
            throw new NoSuchElementException();
        }
        return deleteRec(value, parent).getValue();
    }

    /**
     * Clears the tree
     */
    public void clearTree(){parent = new TreeNode<>(null, null, null);}

    /**
     * @return the minimum value in the tree
     */
    public E findMin(){
        TreeNode<E> min = parent;
        while (min.getLeftChild() != null){
            min = min.getLeftChild();
        }
        return min.getValue();
    }

    /**
     * @return the maximum value in the tree
     */
    public E findMax(){
        TreeNode<E> max = parent;
        while (max.getRightChild() != null){
            max = max.getRightChild();
        }
        return max.getValue();
    }

    /**
     * @return true or false using balancedRec
     */
    public boolean isBalanced(){
        return balancedRec(parent);
    }

    /**
     * @param root is the node to start at
     * @return true if the difference of the height of the tree is either 1 or 0
     */
    private boolean balancedRec(TreeNode<E> root){
        if (root.getRightChild() == null && root.getLeftChild() == null){
            return true;
        }
        if (root.getLeftChild() != null) {
            if (!balancedRec(root.getLeftChild()))
                return false;
        }
        if (root.getRightChild() != null) {
            if (balancedRec(root.getRightChild()))
                return false;
        }
        int difference = (int) Math.pow(countHeight(root.getLeftChild()) - countHeight(root.getRightChild()),2);
        return difference == 1 || difference == 0;
    }
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
        boolean re = false;
        TreeNode<E> v = new TreeNode<>(value, null, null);
        int compare = node.compareTo(v);
        if (compare == 0)
            return true;
        if (node.getLeftChild() != null)
            re = containRec(node.getLeftChild(), value);
        if (re)
            return re;
        if (node.getRightChild() != null)
            re = containRec(node.getRightChild(), value);
        return re;
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
    private TreeNode<E> deleteRec(E value, TreeNode<E> node){
        int compare = node.compareTo(new TreeNode<>(value, null, null));
        if (compare > 0){
            node.setLeftChild(deleteRec(value, node.getLeftChild()));
        }
        else if (compare < 0){
            node.setRightChild(deleteRec(value, node.getRightChild()));
        }
        else {
            if (node.getLeftChild() == null) return node.getRightChild();
            if (node.getRightChild() == null) return node.getLeftChild();

            TreeNode<E> curr = node.getRightChild();
            while (curr.getLeftChild() != null){
                curr = curr.getLeftChild();
            }
            if (node.getLeftChild() != null){
                curr.setLeftChild(node.getLeftChild());
            }
            return curr;
        }
        return node;
    }
}
