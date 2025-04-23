package ch09.practice.exercise7;

public class MusicPlayer {
    public interface PlayResultListener {
        void onSuccess(String title);
        void onError(String title, int errorCode);
    }

    private PlayResultListener playResultListener;

    public void play(String title, boolean isSuccess, PlayResultListener listener) {
        this.playResultListener = listener;
        if (isSuccess) {
            this.playResultListener.onSuccess(title);
        } else {
            this.playResultListener.onError(title, 500);
        }
    }
}
