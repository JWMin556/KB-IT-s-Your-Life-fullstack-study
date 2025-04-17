package ch07.practice.exercise3;

public class Main {
    public static void main(String[] args) {
        Recipe[] recipes = {
                new KoreanRecipe(),
                new VeganRecipe(),
                new FusionRecipe()
        };
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getDescription());
            if (recipe instanceof KoreanRecipe) {
                KoreanRecipe koreanRecipe = (KoreanRecipe) recipe;
                System.out.println(koreanRecipe.getSpicinessLevel());
            }
        }
    }
}
