package strategy.practice;

public class SmoothSkinFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        String output = input.toLowerCase();
        return output + "✨";
    }
}
