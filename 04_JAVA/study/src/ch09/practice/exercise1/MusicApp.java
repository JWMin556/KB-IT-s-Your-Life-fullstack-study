package ch09.practice.exercise1;

public class MusicApp {
    private String title;
    private String artist;
    private String genre;

    public MusicApp(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    class MusicPlayer {
        public MusicPlayer() {}

        void play() {
            if (MusicApp.this.genre.equals("HIPHOP")) {
                System.out.println("\uD83D\uDCA5 " + title + " - " +  artist +" 을(를) 재생합니다. \uD83D\uDCA5");
            } else if (MusicApp.this.genre.equals("POP")) {
                System.out.println("\uD83C\uDFA7 " + title + " - " +  artist +" 을(를) 재생합니다. \uD83C\uDFA7");
            } else if (MusicApp.this.genre.equals("BALLAD")) {
                System.out.println("\uD83C\uDFB5 " + title + " - " +  artist +" 을(를) 재생합니다. \uD83C\uDFB5");
            }
        }
    }
}