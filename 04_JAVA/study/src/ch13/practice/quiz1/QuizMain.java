package ch13.practice.quiz1;

public class QuizMain {
    public static void main(String[] args) {
        String data = """
            초인종이 없을 때를 두 글자로 줄이면? - 노벨
            보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은? - 뚜비두밥
            등산을 좋아하는 왕은? - 하이킹
            고등학생이 싫어하는 나무는? - 야자나무
            포도가 자기소개할 때 하는 말은? - 포도당
            신데렐라가 잠을 못 자면? - 모짜렐라
            <옷장 안에 불이 났다>를 다섯 글자로 하면? - 장안의 화재
            호랑이가 차를 타고 가다가 친구를 만나서 하는 말은? - 타이거
            몸이 아파도 반드시 가야 하는 대학교는? - 가야대
            인사하면서 웃으면? - 하이킥
            자동차를 톡하고 치면? - 카톡
            <이것이 코다>를 세 글자로 줄이면? - 디스코
            소녀가 강으로 여행을 가면? - 걸리버 여행
            소고기가 없는 나라는? - 소고기무국
            드라큘라가 가장 싫어하는 사람은? - 찔러도 피 안 나는 사람
            때돈을 버는 곳은? - 목욕탕
            자동차 키 색은? - 카키색
            해와 달 중, 해만 취재하는 사람은? - 해리포터
            입이 S자로 되어있으면? - EBS
            신문이 일하러 가면? - 일간신문
            """;

        QuizBox<Quiz> quizBox = new QuizBox<>();
        String[] questions = data.split("\n");
        for (String question : questions) {
            String[] parts = question.split("-");
            Quiz quiz = new Quiz(parts[0], parts[1]);
            quizBox.addQuiz(quiz);
        }

        quizBox.printAll();
    }
}
