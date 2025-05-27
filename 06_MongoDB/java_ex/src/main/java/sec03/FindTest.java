package sec03;

import app.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Iterator;

public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        FindIterable<Document> doc = collection.find();
        Iterator itr = doc.iterator();
        while (itr.hasNext()) {  // 이것보다 그냥 for ( : )로 진행하는 게 더 편할 것이다.
            System.out.println("==> findResultRow : "+itr.next());
        }
        Database.close();
    }
}
