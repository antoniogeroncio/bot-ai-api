package br.ufal.botai.web.rest;

import br.ufal.botai.service.AnsweringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/qa")
public class AnsweringResource {

    private AnsweringService answeringService;

    public AnsweringResource(AnsweringService answeringService) {
        this.answeringService = answeringService;
    }

    @GetMapping("/{question}")
    public String answering(@PathVariable("question") String question) throws IOException {
        return answeringService.answering(question);
    }
}
