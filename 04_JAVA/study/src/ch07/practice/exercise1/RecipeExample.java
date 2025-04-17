package ch07.practice.exercise1;

public class RecipeExample {
    public static void main(String[] args) {
        Recipe hyunsoo = new KoreanRecipe();
        Recipe soyoung = new VeganRecipe();

        System.out.println("[현수의 추천 레시피]");
        System.out.println(hyunsoo.getDescription());
        System.out.println(hyunsoo);
        System.out.println();

        System.out.println("[소영의 추천 레시피]");
        System.out.println(soyoung.getDescription());
        System.out.println(soyoung);
    }
}
