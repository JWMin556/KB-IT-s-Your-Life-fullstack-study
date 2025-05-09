package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        //문자 기반 출력 스트림 생성
        try(Writer writer = new FileWriter("C:/Temp/test.txt")) {
            //1 문자씩 출력
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);
            //char 배열 출력
            char[] arr = { 'C', 'D', 'E' };
            writer.write(arr);

            //문자열출력
            writer.write("FGH");
            //버퍼에잔류하고있는문자들을출력하고, 버퍼를비움
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
