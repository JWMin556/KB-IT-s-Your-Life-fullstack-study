package ch09.practice.exercise8;

public class Main {
    public static void main(String[] args) {
        Playable legacy = new LegacyPlayerAdapter(new LegacyPlayer());
        Playable modern = new ModernPlayerAdapter(new ModernPlayer());

        legacy.play("Ditto");
        modern.play("bad song");
        legacy.play("사건의 지평선");
        modern.play("Attention");

    }
}
