package br.ufal.botai.service;

import br.ufal.botai.domain.AnsweringDTO;
import br.ufal.botai.web.rest.vm.QuestionAnsweringVM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "qaClient", url = "${qaClient.url}")
public interface QAClienteService {

    @RequestMapping(method = RequestMethod.POST, value = "/api/qa")
    AnsweringDTO predict(@RequestBody QuestionAnsweringVM questionAnsweringVM);

}
