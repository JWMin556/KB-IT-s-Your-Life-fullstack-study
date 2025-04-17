package ch07.practice.exercise1;

public class Recipe {
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public Recipe(String title, int cookTime, boolean isVegan) {
        this.title = title;
        this.cookTime = cookTime;
        this.isVegan = isVegan;
    }

    public String getDescription() {
        return "이 레시피는 설명이 없습니다.";
    }

    @Override
    public String toString() {
        return title + "(" + cookTime + "분) - " + (isVegan ? "비건" : "비건 아님");
    }
    // System.out.println(객체)의 재정의를 위해서 이렇게 toString을 이용할 수 있다.
}
