package Week4.Example;

import java.util.ArrayList;
import java.util.List;

public class TreeMain {
    public static void main(String[] args) {
        class Node {
            int value;
//            Node next;
            List<Node> nextNodes;
            public Node(int value) {
                this.value = value;
                this.nextNodes = new ArrayList<>();
            }
        }

        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);

        node1.nextNodes.add(node2);
        node2.nextNodes.add(node3);
    }
}
