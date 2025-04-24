package ch14.practice.deepening;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();
        thread.start();

        MusicRunnable musicRunnable = new MusicRunnable();
        musicRunnable.display();
    }
}
