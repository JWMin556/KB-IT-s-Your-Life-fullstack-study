package adapter.adapter1;

public class Banner { // 소스 역할: 이용하고자 하는 코드
    // 이 Banner를 라이브러리 즉, 고칠 수 없는 클래스상태라고 가정하자
    private String string;
    
    public Banner(String string) {
        this.string = string;
    }
    
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }
    
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
