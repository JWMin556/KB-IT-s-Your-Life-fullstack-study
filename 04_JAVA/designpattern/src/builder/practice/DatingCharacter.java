package builder.practice;

public class DatingCharacter implements Comparable<DatingCharacter> {
    private String name;
    private String personality;
    private String hobby;
    private String favoriteFood;
    private String talkStyle;

    private DatingCharacter(Builder builder) {
        this.name = builder.name;
        this.personality = builder.personality;
        this.hobby = builder.hobby;
        this.favoriteFood = builder.favoriteFood;
        this.talkStyle = builder.talkStyle;
    }

    public static class Builder {
        private String name;
        private String personality;
        private String hobby;
        private String favoriteFood;
        private String talkStyle;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder personality(String personality) {
            this.personality = personality;
            return this;
        }

        public Builder hobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Builder favoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
            return this;
        }

        public Builder talkStyle(String talkStyle) {
            this.talkStyle = talkStyle;
            return this;
        }

        public DatingCharacter build() {
            return new DatingCharacter(this);
        }
    }

    @Override
    public int compareTo(DatingCharacter o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        String answer = "이름: " + name + " \n성격: " + personality + "\n취미: " + hobby + "\n좋아하는 음식: " + favoriteFood + "\n말투 스타일 " + talkStyle;
        return answer;
    }
}
