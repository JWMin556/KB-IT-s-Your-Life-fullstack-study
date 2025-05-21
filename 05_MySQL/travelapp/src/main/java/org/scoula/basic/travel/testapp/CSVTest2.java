package org.scoula.basic.travel.testapp;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.basic.travel.domain.TravelVO;

import java.io.FileReader;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws Exception {
        // reflection 기법으로 travels를 만듬
        List<TravelVO> travles = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                // List<TravelVO> 머시기 = new CsvToBeanBuilder<>이렇게 못하는 이유는 CsvToBeanBuilder가 List랑 아무 상관이 없기에 생략하면 에러가 나는 것이다
                .withType(TravelVO.class)
                .build()
                .parse();
        
        travles.forEach(travel -> System.out.println(travel));
    }
}
