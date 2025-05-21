package org.scoula.basic.travel.testapp;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSVTest1 {
    public static void main(String[] args) throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("travel.csv")); //파일 경로가 상대경로임..즉, csv파일을 현재 프로젝트의 루트에 넣어야 함
        String[] line;  // 이 단위로 진행하다 보니, 가독성이 떨어짐. 따라서 VO객체로 맵핑이 필요함
        while ((line = csvReader.readNext()) != null) {
            System.out.println(String.join(",", line));  //배열을 중간에 ,로 합쳐서 반환
        }
    }
}
