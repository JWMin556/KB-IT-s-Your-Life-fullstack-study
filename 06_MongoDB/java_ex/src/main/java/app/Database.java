package app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Database {
    static MongoClient client;
    static MongoDatabase database;

    static {
        // POJO Codec Provider를 자동 설정으로 빌드
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();  // 그냥 이게 필요하다고 외우기 (pojo를 위해서)
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");  // ConnectionString를 통해 userid, pw를 추가적으로 넣을 수 있다
        client = MongoClients.create(connectionString);
//        database = client.getDatabase("todo_db");
        database = client.getDatabase("todo_db").withCodecRegistry(pojoCodecRegistry);
    }

    // client를 close
    public static void close() {
        client.close();
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    // collections을 얻기위해 이것을 가장 많이 사용
    public static MongoCollection<Document> getCollection(String colName) {  // colName은 컬럼명이다.
        // Document는 자바의 Map을 확장해서 만든 것이라고 생각하면 됨
        MongoCollection<Document> collection = database.getCollection(colName);
        return collection;
    }

    public static <T> MongoCollection<T> getCollection(String colName, Class<T> clazz) {
        MongoCollection<T> collection = database.getCollection(colName, clazz);
        return collection;
    }
}
