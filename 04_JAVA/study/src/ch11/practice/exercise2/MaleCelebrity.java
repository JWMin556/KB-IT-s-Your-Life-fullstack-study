package ch11.practice.exercise2;

public class MaleCelebrity implements Celebrity {
    private String name;

    public MaleCelebrity(String name) throws InvalidNameException {
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
        if (!(o instanceof MaleCelebrity)) return false;
        MaleCelebrity that = (MaleCelebrity) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "남자 연예인 :" + name;
    }
}
