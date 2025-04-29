package ch13.practice.quiz345;

public class QuizMain3 {
    public static void main(String[] args) {
        QuizLinkedList quizList = new QuizLinkedList();

        quizList.addLast("초인종이 없을 때를 두 글자로 줄이면?", "노벨");
        quizList.addLast("보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은?", "뚜비두밥");
        quizList.addLast("등산을 좋아하는 왕은?", "하이킹");
        quizList.addLast("고등학생이 싫어하는 나무는?", "야자나무");

        quizList.printAll();
    }
}
