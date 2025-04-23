package ch09.practice.exercise8;

public class ModernPlayerAdapter implements Playable {
    private ModernPlayer player;
    public ModernPlayerAdapter(ModernPlayer player) {
        this.player = player;
    }

    @Override
    public void play(String title) {
        String arbitaryTitle = title.toLowerCase();
        if (arbitaryTitle.contains("bad")) {
            System.out.println("\uD83D\uDEAB 금지어가 포함된 곡은 재생할 수 없습니다: " + title);
        } else {
            player.begin(title);
        }
    }
}
