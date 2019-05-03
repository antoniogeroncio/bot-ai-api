package br.ufal.botai.web.rest.vm;

public class QuestionAnsweringVM {

    private String question;
    private String passage;

    public QuestionAnsweringVM(String question, String passage) {
        this.question = question;
        this.passage = passage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }
}
