package br.ufal.botai.web.rest;


import br.ufal.botai.service.OpenInformationExtractionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ie")
public class OpenInformationExtractionResource {

    private final OpenInformationExtractionService openInformationExtractionService;

    public OpenInformationExtractionResource(OpenInformationExtractionService openInformationExtractionService) {
        this.openInformationExtractionService = openInformationExtractionService;
    }

    @GetMapping
    public String extract(@PathVariable String document) {
        return openInformationExtractionService.extract(document);
    }
}
