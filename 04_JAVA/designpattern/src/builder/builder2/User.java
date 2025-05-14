package builder.builder2;

public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean sex;
    private int age;

    // 디폴트 생성자
    public User() {
    }

    // 모두 받는 생성자 -> 근데 private으로 했음. 이유는 파라미터가 너무 많기 때문에 일부러 호출을 막는다.
    private User(String name, String email, String password, String phone, String address, boolean sex, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    // 내부 클래스 정의. static이 있기에 외부 클래스의 인스턴스 없이도 사용가능
    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String phone;
        private String address;
        private boolean sex;
        private int age;

        private Builder() {}  //private 생성자이기에 외부에서 생성불가

        public Builder name(String name) {
            this.name = name;
            return this; // 일반적인 setter와 달리, 빌더의 setter는 자기자신을 리턴해야 함
            // 이렇게 쓰는 이유는 메서드 체이닝을 위해서 ....
            // .name().email().password()... 이렇게 메서드 체이닝을 하는 것이다.
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder sex(boolean sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(name, email, password, phone, address, sex, age);
        }
    }

    public static Builder builder() {
        return new Builder();  // private 생성자 호출
    }
}
