package Week4.Example;

public class DfsMain {
    public static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void dfs(Node root) {
        // root.value를 어디에 놓느냐에 따라 전위, 중위, 후위
        System.out.println(root.value);
        if (root.left != null) {
            dfs(root.left);
        } 
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public static int dfsCount(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = dfsCount(root.left);
        int rightCount = dfsCount(root.right);
        return leftCount + rightCount + 1;
    }

    public static int dfsDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfsDepth(root.left);
        int rightDepth = dfsDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);

//        dfs(root);
//        System.out.println(dfsCount(root) + "개");
        System.out.println("depth는 " + dfsDepth(root));
    }
}
