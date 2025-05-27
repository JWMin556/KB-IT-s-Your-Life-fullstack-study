package proxy;

// 위임의 방식이다.
public interface Printable {
    void setPrinterName(String name); // 이름 설정
    String getPrinterName(); // 이름 취득
    void print(String string); // 문자열 표시
}
