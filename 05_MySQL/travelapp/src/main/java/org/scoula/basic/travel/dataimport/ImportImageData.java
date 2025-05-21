package org.scoula.basic.travel.dataimport;

import org.scoula.basic.database.JDBCUtil;
import org.scoula.basic.travel.dao.TravelDao;
import org.scoula.basic.travel.dao.TravelDaoImpl;
import org.scoula.basic.travel.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImpl();

        File dir = new File("../travel-image");  // 상대경로이다. 현재 워킹디렉토리의 부모 디렉토리 하에 travel-image를 즉, 루트의 부모디렉토리에
        File[] files = dir.listFiles();
        for (File file : files) {
            String filename = file.getName();
            // 파일 이름의 "-" 앞 부분을 추출해서 관광지 no얻기
            long travelNo = Long.parseLong(filename.split("-")[0]);  // 관광지 no얻기 ex) 001-2.jpg에서 001을 가져오는 것이다.

            TravelImageVO image = TravelImageVO.builder()
                    .filename(filename)
                    .travelNo(travelNo)
                    .build();

            System.out.println(image);
            dao.insertImage(image);
        }

        JDBCUtil.close();
    }
}
