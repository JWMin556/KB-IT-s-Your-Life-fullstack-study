package ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
    public static void main(String[] args) {
        try {
            String data = "" +
                    "id: winter\n" +
                    "email: winter@mycompany.com\n" +
                    "tel: 010-123-1234";
            //Path 객체 생성
            Path path = Paths.get("C:/Temp/user.txt");
            //파일 생성 및 데이터 저장
            Files.writeString(Paths.get("C:/Temp/user.txt"), data, Charset.forName("UTF-8"));
            //파일정보얻기
            // probeContentType을 통해 어떤 유형으로 내보낼지 알려줌. 또한 파일의 크기도 알려줄 필요가 있다.
            System.out.println("파일유형: " + Files.probeContentType(path));
            System.out.println("파일크기: " + Files.size(path) + " bytes");
            //파일읽기
            String content = Files.readString(path, Charset.forName("UTF-8"));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
