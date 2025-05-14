package builder.builder2;

public class Main {
    public static void main(String[] args) {
        User user = User.builder() //리턴값은 Builder
                .name("주머니")
                .email("hong@scoula.org")
                .password("123456")
                .phone("010-1111-22222")
                .address("서울시")
                .sex(true)
                .age(16)
                .build();
        System.out.println(user);
    }
}
