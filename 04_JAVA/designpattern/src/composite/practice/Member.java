package composite.practice;

import facade.pagemaker.PageMaker;

public class Member extends BandComponent {
    private String name;
    private String mbti;
    private String position;
    private int energyLevel;

    public Member(String name, String mbti, String position, int energyLevel) {
        this.name = name;
        this.mbti = mbti;
        this.position = position;
        this.energyLevel = energyLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void perform() {
        String emoji = null;
        String message = null;
        if (energyLevel < 30) {
            emoji = "\uD83D\uDE35";
            message = "너무 지쳐서 공연을 못 하겠어요...";
        } else {
            if (mbti.equals("ENFP")) {
                emoji = "\uD83D\uDD25";
                message = "여러분 안녕!! 불태워볼까요?";
            } else if (mbti.equals("ISTJ")) {
                emoji = "\uD83E\uDDCA";
                message = "공연 시작합니다.";
            } else if (mbti.equals("ISFP")) {
                emoji = "\uD83C\uDF19";
                message = "조용히 시작해볼게요.";
            } else if (mbti.equals("INTP")) {
                emoji = "\uD83E\uDDE0";
                message = "이 곡은 구조적으로 매우 완벽합니다.";
            } else if (mbti.equals("ESFJ")) {
                emoji = "\uD83D\uDC95";
                message = "다들 잘 지냈죠? 오늘도 힘내요!";
            } else {
                emoji = "\uD83C\uDFB6";
                message = "준비됐어요!";
            }
        }
        System.out.println(emoji + "[" + mbti +"] " + name + ": " + message);
    }

    @Override
    public void printStructure(String prefix) {
        System.out.println(prefix + "🎸 " + position + " - " + name + " (" + mbti + ")");
    }
}
