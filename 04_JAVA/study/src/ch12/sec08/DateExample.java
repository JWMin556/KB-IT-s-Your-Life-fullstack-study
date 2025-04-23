package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date now = new Date();  // 현재 날짜와 시간 객체를 자동으로 생성
        String strNow1 = now.toString();
        System.out.println(strNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");  //대소문자 구분해서 날짜 포멧 지정
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }
}
