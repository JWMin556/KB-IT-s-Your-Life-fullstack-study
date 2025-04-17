package ch07.practice.exercise2;

public class VeganRecipe extends Recipe {
    public VeganRecipe() {super("두부 샐러드");}
    @Override
    public String getDescription() {
        return "신선한 두부 샐러드를 추천합니다!";
    }
}
