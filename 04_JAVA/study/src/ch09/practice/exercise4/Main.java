package ch09.practice.exercise4;

public class Main {
    public static void main(String[] args) {
        PlayerUI ui = new PlayerUI();

        // ✅ 전역 모드 설정
        PlayerSettings.Mode.setShuffle(true);
        PlayerSettings.Mode.setRepeat(false);

        // ✅ 익명 구현 객체로 리스너 등록
        ui.setClickListener(new PlayerUI.ClickListener() {
            public void onClick() {
                if (PlayerSettings.Mode.shuffle) {
                    System.out.println("🔀 셔플 모드로 재생합니다.");
                }
                if (!PlayerSettings.Mode.repeat) {
                    System.out.println("⏭ 반복 없이 한 번만 재생합니다.");
                }
                if (PlayerSettings.Mode.repeat && !PlayerSettings.Mode.shuffle) {
                    System.out.println("\"▶ 일반 모드로 재생합니다.\"");
                }
            }
        });

        // ✅ 버튼 클릭 시 동작
        ui.clickPlayButton();
    }
}
