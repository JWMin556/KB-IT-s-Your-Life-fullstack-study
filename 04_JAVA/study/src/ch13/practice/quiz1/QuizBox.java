package ch13.practice.quiz1;

import java.util.Arrays;

public class QuizBox<T extends Quiz> {
    private T[] list;
    private int size;

    public QuizBox() {
        list = (T[]) new Quiz[5];
        size = 0;
    }

    public void addQuiz(T quiz) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[size++] = quiz;
    }

    public void printAll() {
        System.out.println("=== 퀴즈 박스 문제 목록 ===");
        for (int i = 0; i < size; i++) {
            String question = list[i].getQuestion();
            System.out.println(i + 1 + ". " + question);
        }
    }
}
