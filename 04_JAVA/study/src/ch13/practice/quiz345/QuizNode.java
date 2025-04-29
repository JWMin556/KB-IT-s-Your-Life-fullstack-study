package ch13.practice.quiz345;

public class QuizNode {
    private String title;
    private String content;
    private QuizNode next;

    public QuizNode(String title, String content, QuizNode next) {
        this.title = title;
        this.content = content;
        this.next = next;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public QuizNode getNext() {
        return next;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNext(QuizNode next) {
        this.next = next;
    }
}
