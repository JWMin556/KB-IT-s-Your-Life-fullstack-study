package ch11.practice.exercise2;

public class FemaleCelebrity implements Celebrity {
    private String name;
    public FemaleCelebrity(String name) throws InvalidNameException {
        String regExp = "^[가-힣]{2,10}$";
        if (name.matches(regExp)) {
            this.name = name;
        } else {
            throw new InvalidNameException("\uD83D\uDE21 탈락! 잘못된 이름입니다: 이름은 한글 2~10자여야 합니다!");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FemaleCelebrity)) return false;
        FemaleCelebrity that = (FemaleCelebrity) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "여자 연예인 :" + name;
    }
}
