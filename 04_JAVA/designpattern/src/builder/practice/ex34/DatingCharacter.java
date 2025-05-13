package builder.practice.ex34;

public class DatingCharacter implements Comparable<DatingCharacter>, CharacterType{
    private String name;
    private String personality;
    private String hobby;
    private String favoriteFood;
    private String talkStyle;
    private String typeCode;

    private DatingCharacter(Builder builder) {
        this.name = builder.name;
        this.personality = builder.personality;
        this.hobby = builder.hobby;
        this.favoriteFood = builder.favoriteFood;
        this.talkStyle = builder.talkStyle;
        this.typeCode = builder.typeCode;
    }

    public static class Builder {
        private String name;
        private String personality;
        private String hobby;
        private String favoriteFood;
        private String talkStyle;
        private String typeCode;

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

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
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
    public String getTypeCode() {
        return typeCode;
    }

    public String getName() {
        return name;
    }

    public String getTalkStyle() {
        return talkStyle;
    }

    @Override
    public String toString() {
        String answer = "이름: " + name + " / 성격: " + personality + " / 유형: " + typeCode;
        return answer;
    }
}
