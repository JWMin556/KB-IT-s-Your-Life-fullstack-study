package Week4.Advanced;

import java.util.ArrayList;
import java.util.List;

public class InfectedFolder {
//    static Map<String, List<String>> foldersGraph = new HashMap<>();
//
//    public static void makeTree(String[][] folders) {
//        for (String[] folder : folders) {
//            if (foldersGraph.containsKey(folder[0])) {
//                foldersGraph.get(folder[0]).add(folder[1]);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(folder[1]);
//                foldersGraph.put(folder[0], list);
//            }
//        }
//    }

    public static class Node {
        int value;
        List<Node> nextNodes;
        public Node(int value) {
            this.value = value;
            nextNodes = new ArrayList<Node>();
        }
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return null;
    }


    public static String solution(String[][] folders, String p, String q) {
        String answer = "";

        return answer;
    }

    public static void main(String[] args) {

    }
}
