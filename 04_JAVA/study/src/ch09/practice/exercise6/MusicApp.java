package ch09.practice.exercise6;

public class MusicApp {
    private String user = "yura";

    public static class PlayerUI {
        public void show(MusicApp app) {
            System.out.println("🎧 현재 사용자: " + app.user); // ❌ 컴파일 에러 발생
        }
    }

    public static void main(String[] args) {
        MusicApp.PlayerUI ui = new MusicApp.PlayerUI();
        ui.show(new MusicApp());
    }
}
