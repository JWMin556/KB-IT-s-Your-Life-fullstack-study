package sec01;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {
    public static void main(String[] args) {
        String url = "mongodb://127.0.0.1:27017";
        String db = "todo_db";

        try (MongoClient client = MongoClients.create(url)) {
            MongoDatabase database = client.getDatabase(db);
            System.out.println("Connected to database" + database);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
