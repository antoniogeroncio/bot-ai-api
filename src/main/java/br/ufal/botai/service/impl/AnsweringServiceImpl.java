package br.ufal.botai.service.impl;

import br.ufal.botai.domain.AnsweringDTO;
import br.ufal.botai.service.AnsweringService;
import br.ufal.botai.service.GoogleSearchService;
import br.ufal.botai.service.QAClienteService;
import br.ufal.botai.web.rest.vm.QuestionAnsweringVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AnsweringServiceImpl implements AnsweringService {

    private GoogleSearchService googleSearchService;
    private QAClienteService qaClienteService;

    @Autowired
    public AnsweringServiceImpl(GoogleSearchService googleSearchService, QAClienteService qaClienteService) {
        this.googleSearchService = googleSearchService;
        this.qaClienteService = qaClienteService;
    }

    @Override
    public String answering(String question) throws IOException {
        String results = googleSearchService.search(question);
        AnsweringDTO answering = qaClienteService.predict(new QuestionAnsweringVM(question, results));
        return answering.getAnswering();
    }
}
