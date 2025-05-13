package builder.builder1;

public class Director {
    private Builder builder;

    // Director는 어떤 Builder가 올지 모른다. 다만, 결과물을 호출할 뿐이다.
    // OCP

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 문서를 만드는 메서드
    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("일반적인 인사");

        //배열을 생성해서 넘기는 코드
        builder.makeItems(new String[] {
                "How are you?",
                "Hello.",
                "Hi.",
        });
        builder.makeString("시간대별 인사");
        builder.makeItems(new String[] {
                "Good morning.",
                "Good afternoon.",
                "Good evening.",
        });
        builder.close();
    }
}
