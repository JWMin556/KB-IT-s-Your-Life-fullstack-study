package org.scoula.domain;

public class Dog {
    private String name;
    private String breed;

    public Dog() {}

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "[Dog]" +
                "이름: " + name + ", " +
                "견종: " + breed;
//        return "[" + breed +  "] " +  name;
    }
}
