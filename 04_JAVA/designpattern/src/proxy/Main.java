package proxy;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrintProxy("Alice");  //실행하는 쪽은 여기밖에 모른다. 즉, Printtable만 알고 있지, Printer를 사용하는지 proxy를 사용하는지 모른다. 
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.setPrinterName("Bob"); // 생성 -> 5초 지연
        p.print("Hello Bob!");
    }
}
