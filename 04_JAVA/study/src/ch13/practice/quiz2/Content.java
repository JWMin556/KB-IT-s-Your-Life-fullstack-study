package ch13.practice.quiz2;

import java.util.Objects;

public class Content {
    private String question;

    public Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Content content)) return false;
        return Objects.equals(question, content.question);
    }
}
