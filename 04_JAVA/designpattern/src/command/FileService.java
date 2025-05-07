package command;

public class FileService {
    String filename;

    // 모두 command 인터페이스에 준한다.
    void open() {
        filename = "test.txt";
        System.out.println(filename + "열었습니다.");
    }

    void print() {
        // 물론, 먼저 open을 해야만 filename이 적용될 것이다.
        System.out.println(filename + "프린트 합니다.");
    }
}
