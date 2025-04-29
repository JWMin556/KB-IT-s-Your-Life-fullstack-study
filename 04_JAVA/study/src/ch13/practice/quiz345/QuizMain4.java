package ch13.practice.quiz345;

public class QuizMain4 {
    public static void main(String[] args) {
        QuizLinkedList quizList = new QuizLinkedList();

        // 문제들 추가 (addLast)
        quizList.addLast("몸이 아파도 반드시 가야 하는 대학교는?", "가야대");
        quizList.addLast("인사하면서 웃으면?", "하이킥");
        // 맨 앞에 문제 추가 (addFirst)
        quizList.addFirst("호랑이가 차를 타고 가다가 친구를 만나서 하는 말은?", "타이거");
        // 1번 인덱스에 문제 추가 (addAt)
        quizList.addAt(1, "자동차 키 색은?", "카키색");
        // 리스트 출력
        quizList.printAll();
        // 현재 문제 수 출력
        System.out.println("=== 현재 문제 수 ===");
        System.out.println(quizList.size());
        System.out.println();
        // 첫 번째 문제 삭제
        quizList.removeFirst();
        // 리스트 다시 출력
        System.out.println("=== 첫 번째 문제 삭제 후 리스트 ===");
        quizList.printAll();
    }
}
