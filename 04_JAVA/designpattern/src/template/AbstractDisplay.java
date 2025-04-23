package template;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    
    //final이 붙었기에 오버라이드 불가능
    // 템플릿 메서드
    public final void display() {
        open();
        for (int i =0; i < 5; i++) {
            print();
        }
        close();
    }
}
