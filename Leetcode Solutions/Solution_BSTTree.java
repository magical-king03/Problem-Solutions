class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution_BSTTree {
    TreeNode root;

    public Solution_BSTTree() {
        root = null;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val == 0) {
            return root;
        }
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public static TreeNode helper(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return helper(root.left, val);
        } else {
            return helper(root.right, val);
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        return helper(root, val);
    }

    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public static TreeNode deleteNodeBST(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNodeBST(root.right, key);
        else if (key < root.val) root.left = deleteNodeBST(root.left, key);
        else {
          if (root.left == null && root.right == null) root = null;
          else if (root.right != null) {
            root.val = successor(root);
            root.right = deleteNodeBST(root.right, root.val);
          }
          else {
            root.val = predecessor(root);
            root.left = deleteNodeBST(root.left, root.val);
          }
        }
        return root;
      }

    public static void main(String[] args) {
        Solution_BSTTree tree = new Solution_BSTTree();

        System.out.println("Problem 44: ");
        int[] root_p44 = { 4, 2, 7, 1, 3 };
        for (int i : root_p44) {
            tree.insert(i);
        }
        int val_p44 = 2;
        TreeNode ans_p44 = searchBST(tree.root, val_p44);
        tree.inorder();
        System.out.println();
        if (ans_p44 == null) {
            System.out.println("Element not found!");
        } else {
            tree.inorderRec(ans_p44);
        }

        System.out.println();
        System.out.println("Problem 45: ");
        tree.root = null;
        int[] root_p45 = { 5, 3, 6, 2, 4, 0, 7 };
        for (int i : root_p45) {
            tree.insert(i);
        }
        tree.inorder();
        System.out.println();
        int val_p45 = 3;
        TreeNode ans_p45 = deleteNodeBST(tree.root, val_p45);
        if (ans_p45 == null) {
            System.out.println("Element not found!");
        } else {
            tree.inorderRec(ans_p45);
        }
    }
}
