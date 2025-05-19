package strategy.practice;

public class CuteEyesFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                output.append("👁");
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }
}
