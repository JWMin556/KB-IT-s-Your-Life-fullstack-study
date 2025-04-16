package ch06.practice.deepening1;

public class DatabaseExample {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        String dbms = db1.connect();
        System.out.println("데이터 베이스: " + dbms);
        db2.close();

        System.out.println(db1 == db2);
    }
}
