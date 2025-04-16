package ch06.practice.deepening2;

public class InputTest {
    public static void main(String[] args) {
        String name = Input.read("이름: ");
        System.out.println("입력값: " + name);

        // 기본값 포함한 이름 입력
        String defaultName = Input.read("이름", "홍길동");
        System.out.println("입력값: " + defaultName);

        // 정수 입력
        int age = Input.readInt("나이: ");
        System.out.println("입력값: " + age);

        // confirm입력
        boolean shouldClose = Input.confirm("종료할까요?", false);
        System.out.println("입력값: " + shouldClose);

        boolean shouldClose2 = Input.confirm("종료할까요?", false);
        System.out.println("입력값" + shouldClose2);
    }
}
