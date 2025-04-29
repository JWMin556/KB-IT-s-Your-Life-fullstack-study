package ch13.practice.quiz345;

import java.util.Iterator;

public class QuizIterator implements Iterator<QuizNode> {
    private QuizNode current;

    public QuizIterator(QuizNode head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public QuizNode next() {
        QuizNode next = current;
        current = current.getNext();
        return next;
    }
}
