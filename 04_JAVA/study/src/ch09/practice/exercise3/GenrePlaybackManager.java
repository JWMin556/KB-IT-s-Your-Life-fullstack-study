package ch09.practice.exercise3;

public class GenrePlaybackManager {
    public static interface GenrePlayer {
        // 추상 메서드
        void play(String title, String artist);
    }

    //필드
    private GenrePlayer genrePlayer;

    public void setPlayer(GenrePlayer player) {
        this.genrePlayer = player;
    }
    public void play(String title, String artist) {
        this.genrePlayer.play(title, artist);
    }
}
