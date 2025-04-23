package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        // 메소드 체이닝 패턴
        String data = new StringBuilder()
                .append("DEF")
                .insert(0, "ABC")
                .delete(3,4)
                .toString();
        System.out.println(data);
    }
}
