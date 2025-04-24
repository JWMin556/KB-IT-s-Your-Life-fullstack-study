package ch11.practice.exercise34567;

public class CheckGender {
    private int gender;

    public int getGender() {
        return gender;
    }

    public CheckGender(String gender) throws InvalidGenderException {
        try {
            int genderInt = Integer.parseInt(gender);
            if (genderInt == 1 || genderInt == 2) {
                this.gender = genderInt;
            } else {
                throw new InvalidGenderException("잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidGenderException("숫자만 입력하세요! (1 또는 2)");
        }

    }
}
