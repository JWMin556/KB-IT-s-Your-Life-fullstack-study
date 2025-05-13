package builder.builder2;

public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean sex;
    private int age;

    public User() {
    }

    public User(String name, String email, String password, String phone, String address, boolean sex, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }


}
