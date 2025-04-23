package ch09.sec06.exam03;

public class Button {
    public static interface ClickListener {
        void onClick();
    }

    //필드
    private Button.ClickListener clickListener;

    //메소드
    public void setClickListener(Button.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }
}
