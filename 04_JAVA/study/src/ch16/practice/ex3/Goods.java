package ch16.practice.ex3;

public class Goods {
    private String name;
    private String color;
    private boolean useful;

    public Goods(String name, String color, boolean useful) {
        this.name = name;
        this.color = color;
        this.useful = useful;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isUseful() {
        return useful;
    }

    @Override
    public String toString() {
        return name + "(" + color + ")";
    }
}
