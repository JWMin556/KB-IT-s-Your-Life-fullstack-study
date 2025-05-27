package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        // Document는 bson에 있는 것을 가져와야 함
        MongoCollection<Document> collection = Database.getCollection("todo");
        List<Document> insertList = new ArrayList<>();
        Document document1 = new Document();
        Document document2 = new Document();

        document1.append("title", "Dune2 영화보기");
        document1.append("desc", "이번 주말 IMAX로 Dune2 영화보기");
        document1.append("done", false);
        document2.append("title", "Java MongoDB 연동");
        document2.append("desc", "Java로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done", false);
        
        // 문서들을 리스트에 추가
        insertList.add(document1);
        insertList.add(document2);
        
        // 문서들을 'todo'컬렉션에 삽입
        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());  // 삽입된 문서들의 ID 출력
        Database.close();
    }
}
