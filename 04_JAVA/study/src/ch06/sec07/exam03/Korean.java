package ch06.sec07.exam03;

public class Korean {
    String nation = "대한민국";
    String name;
    String ssn;

    public Korean(String name, String ssn) {
        this.name = name;  //this가 붙은 것이 필드 변수
        this.ssn = ssn; // 매개변수를 필드 변수에 할당
    }

}
