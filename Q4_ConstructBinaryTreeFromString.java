import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Q4_ConstructBinaryTreeFromString {
    private int index;

    public TreeNode constructBinaryTreeFromString(String s) {
        if (s.isEmpty()) {
            return null;
        }

        // Find the root node's value
        StringBuilder rootValBuilder = new StringBuilder();
        int i = 0;
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
            rootValBuilder.append(s.charAt(i));
            i++;
        }

        // Create the root node
        TreeNode root = new TreeNode(Integer.parseInt(rootValBuilder.toString()));

        if (i == s.length()) {
            // No child nodes, return the root
            return root;
        }

        // Find the substring for the left child
        int start = i;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count == 0) {
                break;
            }

            i++;
        }

        // Recursive call for the left child
        root.left = constructBinaryTreeFromString(s.substring(start + 1, i));

        if (i + 1 < s.length()) {
            // Find the substring for the right child
            start = i + 1;
            count = 0;
            i = start;

            while (i < s.length()) {
                if (s.charAt(i) == '(') {
                    count++;
                } else if (s.charAt(i) == ')') {
                    count--;
                }

                if (count == 0) {
                    break;
                }

                i++;
            }

            // Recursive call for the right child
            root.right = constructBinaryTreeFromString(s.substring(start + 1, i));
        }

        return root;
    }

    // Perform a preorder traversal to get the output as a list
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        Q4_ConstructBinaryTreeFromString solution = new Q4_ConstructBinaryTreeFromString();
        TreeNode root = solution.constructBinaryTreeFromString(s);
        List<Integer> output = solution.preorderTraversal(root);
        System.out.println(output);
    }
}



