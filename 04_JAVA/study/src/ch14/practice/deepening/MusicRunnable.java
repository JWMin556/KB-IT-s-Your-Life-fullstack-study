package ch14.practice.deepening;

public class MusicRunnable implements Runnable {
    @Override
    public void display() {
        for (int i = 0; i < 6; i++) {
            System.out.println("음악을 재생합니다.");
            try {Thread.sleep(500);}  catch (Exception e) {}
        }
    }
}
