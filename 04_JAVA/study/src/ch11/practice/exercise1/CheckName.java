package ch11.practice.exercise1;

public class CheckName {
    private String name;
    public CheckName(String name) throws InvalidNameException {
        String regExp = "^[가-힣]{2,10}$";
        if (name.matches(regExp)) {
            System.out.println("(다음 단계로 진행합니다!)");
            this.name = name;
        } else {
            throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
        }
    }
}
