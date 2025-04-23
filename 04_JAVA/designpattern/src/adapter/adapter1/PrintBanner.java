package adapter.adapter1;

// 얘가 adapter
// 이용하고 싶은 것을 상속받고
// 클라이언트에게 맞추려고 implements를 한다.
public class PrintBanner extends Banner implements  Print{
    public PrintBanner(String string) {
        super(string);
    }

    // alt + enter로 해도 됨
    @Override
    public void printWeak() {
        showWithParen(); // 부모클래스 호출
        // 즉, 기존에 있던 라이브러리의 코드를 printWeak가 둘러 싼 wrapper의 형태를 띈다. -> 그래서 Wrappter 패턴
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
