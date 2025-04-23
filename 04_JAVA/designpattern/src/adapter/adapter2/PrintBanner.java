package adapter.adapter2;

public class PrintBanner extends Print {
    private Banner banner;  //위임 객체

    // 얘는 adater1의 상속버젼과 통일시킨 것이며
    public PrintBanner(String string) {
        banner = new Banner(string);
    }

    // 일반적으로 생성자는 이렇다.
    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
