package ch12.sec03.exam01;

import java.util.Objects;

public class Member {
    public String id;
    public String name;
    public int age;

    public Member(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 마찬가지로 alt + insert로 자동완성
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Member member)) return false;
        return age == member.age && Objects.equals(id, member.id) && Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
