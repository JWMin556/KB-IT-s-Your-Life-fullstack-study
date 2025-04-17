package ch07.practice.exercise2;

public class Recipe {
    protected String title;

    public Recipe(String title) {
        this.title = title;
    }

    public String getDescription() {
        return "추천할 대상이 없다.";
    }
}
