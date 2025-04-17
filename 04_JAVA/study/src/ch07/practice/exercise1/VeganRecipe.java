package ch07.practice.exercise1;

public class VeganRecipe extends Recipe {
    public VeganRecipe() {
        super("두부 샐러드", 10, true);
    }

    @Override
    public String getDescription() {
        return "신선한 두부 샐러드를 추천합니다!";
    }
}
