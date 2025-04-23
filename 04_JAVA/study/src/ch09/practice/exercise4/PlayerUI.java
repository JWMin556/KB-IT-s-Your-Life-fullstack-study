package ch09.practice.exercise4;

public class PlayerUI {
    public interface ClickListener {
        void onClick();
    }
    private ClickListener clickListener;

    void setClickListener(ClickListener listener) {
        this.clickListener = listener;
    }
    void clickPlayButton() {
        if (this.clickListener == null) {
            System.out.println("❌ 리스너가 등록되지 않았습니다.");
        } else {
            this.clickListener.onClick();
        }
    }
}
