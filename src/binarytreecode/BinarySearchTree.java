// package binarytreecode;
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType> {

    public void insert(dataType d) {
        if (root == null)
            root = new BinaryTreeNode<>(d, null, null);
        else
            insert(d, root);
    }

    public void insert(dataType d, BinaryTreeNode<dataType> node) {
        if (d.compareTo(node.data) <= 0) {
            if (node.left == null)
                node.left = new BinaryTreeNode<>(d, null, null);
            else
                insert(d, node.left);
        } else {
            if (node.right == null)
                node.right = new BinaryTreeNode<>(d, null, null);
            else
                insert(d, node.right);
        }
    }

    public BinaryTreeNode<dataType> searchByTerm(dataType d) {
        return searchByTerm(d, root);
    }

    private BinaryTreeNode<dataType> searchByTerm(dataType d, BinaryTreeNode<dataType> node) {
        if (node == null) return null;
        if (d.compareTo(node.data) == 0)
            return node;
        else if (d.compareTo(node.data) < 0)
            return searchByTerm(d, node.left);
        else
            return searchByTerm(d, node.right);
    }

    public BinaryTreeNode<dataType> searchByTermAndSentence(dataType term, String sentence) {
        return searchByTermAndSentence(term, sentence, root);
    }

    private BinaryTreeNode<dataType> searchByTermAndSentence(dataType term, String sentence, BinaryTreeNode<dataType> node) {
        if (node == null) return null;
        int termComparison = term.compareTo(node.data);
        if (termComparison == 0 && node.data instanceof Statement) {
            Statement statement = (Statement) node.data;
            if (statement.getSentence().equals(sentence))
                return node;
        }
        if (termComparison < 0)
            return searchByTermAndSentence(term, sentence, node.left);
        else
            return searchByTermAndSentence(term, sentence, node.right);
    }

    public BinaryTreeNode<dataType> find(dataType d) {
        if (root == null)
            return null;
        else
            return find(d, root);
    }

    public BinaryTreeNode<dataType> find(dataType d, BinaryTreeNode<dataType> node) {
        if (d.compareTo(node.data) == 0)
            return node;
        else if (d.compareTo(node.data) < 0)
            return (node.left == null) ? null : find(d, node.left);
        else
            return (node.right == null) ? null : find(d, node.right);
    }

    public void delete(dataType d) {
        root = delete(d, root);
    }

    public BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node) {
        if (node == null) return null;
        if (d.compareTo(node.data) < 0)
            node.left = delete(d, node.left);
        else if (d.compareTo(node.data) > 0)
            node.right = delete(d, node.right);
        else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = removeMin(node.right);
        } else
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        return node;
    }

    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node) {
        if (node != null)
            while (node.left != null)
                node = node.left;
        return node;
    }

    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node) {
        if (node == null)
            return null;
        else if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else
            return node.right;
    }

    // Display the tree
    public void displayTree() {
        displayTree(root, 0);
    }

    // Helper method for displaying the tree (in-order traversal)
    private void displayTree(BinaryTreeNode<dataType> node, int level) {
        if (node != null) {
            displayTree(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(node.data);
            displayTree(node.left, level + 1);
        }
    }
}
