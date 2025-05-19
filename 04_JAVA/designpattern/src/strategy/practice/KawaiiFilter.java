package strategy.practice;

public class KawaiiFilter implements  FilterStrategy{
    @Override
    public String apply(String input) {
        StringBuilder output = new StringBuilder();
        output.append(input);
        output.reverse();
        return output.toString() + "🌸";
    }
}
