package ch13.practice.quiz345;

import java.util.Iterator;

public class QuizLinkedList implements Iterable<QuizNode> {
    private QuizNode head;  // 첫 번째 문제를 가리켜야 함
    private int size;

    public QuizLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public QuizNode search(int index) {
        QuizNode n = head;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        return n;
    }

    public int size() {
        return size;
    }

    public void addFirst(String title, String content) {
        QuizNode first = head;
        QuizNode newNode = new QuizNode(title, content, first);
        size++;
        head = newNode;
    }

    public void addLast(String title, String content) {
        QuizNode newNode = new QuizNode(title, content, null);
        size++;
        if (head == null) {
            head = newNode;
        } else {
            QuizNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void addAt(int index, String title, String content) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(title, content);
        }

        if (index == size - 1) {
            addLast(title, content);
        }

        QuizNode prev_node = search(index - 1);
        QuizNode next_node = prev_node.getNext();
        QuizNode new_node = new QuizNode(title, content, next_node);
        size++;

        prev_node.setNext(new_node);
    }

    public void removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            QuizNode first = head.getNext();  // 두 번째 노드를 임시저장

            head.setTitle(null);
            head.setContent(null);

            head = first;
            size--;
        }
    }

    public void printAll() {
        QuizNode current = this.head;
        System.out.println("=== 현재 도전할 문제 리스트 ===");
        while (current != null) {
            String title = current.getTitle();
            String content = current.getContent();
            System.out.println("문제 제목: " + title);
            System.out.println("문제 내용: " + content);
            System.out.println();
            current = current.getNext();
        }
    }

    @Override
    public Iterator<QuizNode> iterator() {
        return new QuizIterator(head);
    }
}
