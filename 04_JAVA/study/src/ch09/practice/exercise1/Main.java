package ch09.practice.exercise1;

public class Main {
    public static void main(String[] args) {
        MusicApp app1 = new MusicApp("Drowning", "WOODS", "HIPHOP");
        MusicApp.MusicPlayer player1 = app1.new MusicPlayer();
        player1.play();

        MusicApp app2 = new MusicApp("오늘만 I LOVE YOU", "BOYNEXTDOOR", "POP");
        MusicApp.MusicPlayer player2 = app2.new MusicPlayer();
        player2.play();

        MusicApp app3 = new MusicApp("그녀가 웃잖아", "LUCY", "BALLAD");
        MusicApp.MusicPlayer player3 = app3.new MusicPlayer();
        player3.play();
    }
}
