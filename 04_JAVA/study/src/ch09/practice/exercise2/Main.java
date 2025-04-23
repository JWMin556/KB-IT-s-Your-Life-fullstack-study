package ch09.practice.exercise2;

public class Main {
    public static void main(String[] args) {
        PlayerSettings.Mode.printSettings();
        System.out.println();
        PlayerSettings.Mode.setShuffle(true);
        PlayerSettings.Mode.setRepeat(false);
        PlayerSettings.Mode.setVolumeLevel(11);
        PlayerSettings.Mode.setVolumeLevel(7);
        System.out.println();
        PlayerSettings.Mode.printSettings();
    }
}
