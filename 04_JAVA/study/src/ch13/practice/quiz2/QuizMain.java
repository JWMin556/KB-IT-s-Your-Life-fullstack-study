package ch13.practice.quiz2;

public class QuizMain {
    public static void main(String[] args) {
        QuizBox<Quiz> quizBox = new QuizBox<>();
        quizBox.addQuiz(new Quiz("바나나가 웃으면?", "바나나킥"));
        quizBox.addQuiz(new Quiz("자동차가 뒤로 가면?", "트럭"));
        quizBox.addQuiz(new Quiz("세상에서 가장 빠른 새는?", "눈 깜짝할 새"));

        System.out.println("=== 삭제 전 문제 목록 ===");
        quizBox.printAll();

        // 1. static 메소드 removeFromBox() 사용
        Quiz quizToDelete = new Quiz("자동차가 뒤로 가면?", "트럭");
        QuizBox.removeFromBox(quizBox, quizToDelete);

        System.out.println("\n=== removeFromBox() 사용 후 문제 목록 ===");
        quizBox.printAll();

        // 2. 인스턴스 메소드 remove() 사용
        Quiz anotherQuizToDelete = new Quiz("바나나가 웃으면?", "바나나킥");
        boolean removed = quizBox.remove(anotherQuizToDelete);

        if (removed) {
            System.out.println("\n바나나 문제가 정상적으로 삭제되었습니다.");
        } else {
            System.out.println("\n바나나 문제 삭제에 실패했습니다.");
        }

        System.out.println("\n=== remove() 사용 후 최종 문제 목록 ===");
        quizBox.printAll();
    }
}
