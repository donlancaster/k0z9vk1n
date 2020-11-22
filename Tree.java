public class Tree {
    Node root;

    Tree() {
        root = null;
    }

    void deleteKey(int key) {
        root = deleteR(root, key);
    }

    Node deleteR(Node current, int value) {
        if (current == null)
            return null;

        if (value < current.key)
            current.left = deleteR(current.left, value);
        else if (value > current.key)
            current.right = deleteR(current.right, value);
        else {
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;

            current.key = min(current.right);

            current.right = deleteR(current.right, current.key);
        }
        return current;
    }

    int min(Node current) {
        int min = current.key;
        while (current.left != null) {
            min = current.left.key;
            current = current.left;
        }
        return min;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.key) {
            current.left =insertRec(current.left, value);
        } else if (value > current.key) {
            current.right = insertRec(current.right, value);
        } else {
            return current;
        }

        return current;
    }


    void inorder() {
        inoderRecursive(root);
        System.out.println();
    }

    void inoderRecursive(Node root) {
        if (root != null) {
            inoderRecursive(root.left);
            System.out.print(root.key + " ");
            inoderRecursive(root.right);
        }
    }

    void preorder() {
        preorderRecursive(root);
        System.out.println();
    }

    void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    void postorder() {
        postorderRecursive(root);
        System.out.println();
    }

    void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    boolean contains(int value) {
        return containsRecursive(root, value);
    }

    boolean containsRecursive(Node current, int value) {
        if (current == null)
            return false;
        if (value == current.key)
            return true;
        return value < current.key
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }
}
