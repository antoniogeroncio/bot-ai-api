package br.ufal.botai.web.rest;

import br.ufal.botai.service.GoogleSearchService;
import com.google.api.services.customsearch.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class GoogleSearchResource {

    private GoogleSearchService googleSearchService;

    public GoogleSearchResource(GoogleSearchService googleSearchService) {
        this.googleSearchService = googleSearchService;
    }

    @GetMapping("/{searchString}")
    public List<Result> search(@PathVariable("searchString") String searchString) throws IOException {
        return googleSearchService.search(searchString);
    }
}
