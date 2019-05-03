package br.ufal.botai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnsweringDTO {

    private String answering;

    @JsonProperty("best_span_str")
    public String getAnswering() {
        return answering;
    }

    public void setAnswering(String answering) {
        this.answering = answering;
    }

}
