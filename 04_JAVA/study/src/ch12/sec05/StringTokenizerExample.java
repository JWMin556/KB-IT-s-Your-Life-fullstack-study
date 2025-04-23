package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");  // 정규 표현식 사용
        for(String token : arr) {
            System.out.println(token);
        }
        System.out.println();
        // StringTokenizer 클래스를 이용한 문자열 분리
        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/"); // 해당 구분자로 분리해서 객체를 생성한다.
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
