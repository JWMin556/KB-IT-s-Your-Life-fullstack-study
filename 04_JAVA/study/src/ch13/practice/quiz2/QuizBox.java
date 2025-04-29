package ch13.practice.quiz2;

import java.util.Arrays;

public class QuizBox<T extends Content> {
    private T[] list;
    private int size;

    public QuizBox() {
        list = (T[]) new Content[5];
        size = 0;
    }

    public void addQuiz(T content) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[size++] = content;
    }

    public boolean remove(Content content) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(content)) {
                list[i] = list[i + 1];
                for (int j = i + 1; j < size; j++) {
                    list[j] = list[j + 1];
                }
                size--;
                found = true;
            } else {
                found = false;
            }
        }
        return found;
    }

    public static <T extends Content> void removeFromBox(QuizBox<? super T> box, T quiz) {
        box.remove(quiz);
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            String question = list[i].getQuestion();
            System.out.println(i + 1 + ". " + question);
        }
    }
}
