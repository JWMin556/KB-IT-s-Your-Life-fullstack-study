package ch11.practice.exercise34567;

import ch11.practice.exercise2.Celebrity;

public class WinnerAnnouncer {
    private String[] comment = {
            "운명적인 만남! :왕관:",
            "불꽃 튀는 승부! :불:",
            "눈부신 이상형입니다! :반짝임:",
            "모두가 인정한 최강 이상형! :트로피:",
            "세상에 이런 이상형이?! :별2:",
            "만장일치! 역대급 이상형 탄생! :짠:",
            "찢었다! 레전드 우승자! :쾅:",
            "마음 속 1픽, 오늘도 나의 선택은 당신! :반짝이는_하트:",
            "심사위원장이 소름 돋았다네요… :추워하는_얼굴:",
            "우승자의 미모에 심사위원장 쓰러짐 :어지러워하는_얼굴:",
            "태어날 때부터 월드컵 우승자였던 사람 :선글라스:",
            "시작도 전에 결승전 확정된 이상형! :로켓:",
            "치명적인 매력… 모두를 홀렸다! :자석:",
            "이건 신이 선택한 이상형입니다… :결백:",
            "이상형 월드컵 역사상 최초! 완벽한 우승자! :스포츠_메달:",
            "심사위원장: '솔직히 이 사람 나도 찍었다' :눈을_뜨고_손을_입_위에_대고_있는_얼굴:",
            "상대팀 모두 GG 선언하고 퇴장 :울음:",
            "오늘부터 내 배경화면 예약",
            "다음 시즌 결승 진출권 자동 확보 ",
            "사람인가, 조각인가… "
    };

    private String getRandomComment() {
        return "✨ 오늘의 멘트: " + comment[(int) (Math.random() * comment.length)];
    }

//    private void getDateFormatChoice() {
//        System.out.print("");
//    }

    public void printWinnerSummary(Celebrity celebrity) {
        System.out.println("\n🏆 최종 우승자: " + celebrity.getName());
        getRandomComment();

    }
}
