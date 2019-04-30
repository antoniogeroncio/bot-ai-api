package br.ufal.botai.service.impl;

import br.ufal.botai.service.GoogleSearchService;
import br.ufal.botai.service.NlpService;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleSearchServiceImpl implements GoogleSearchService {

    @Value("${googleSearch.key}")
    private String key;

    @Value("${googleSearch.project}")
    private String projetc;

    @Value("${googleSearch.numOfResults}")
    private Integer numOfResults;

    private Customsearch customsearch;
    private NlpService nlpService;

    @Autowired
    public GoogleSearchServiceImpl(Customsearch customsearch, NlpService nlpService) {
        this.customsearch = customsearch;
        this.nlpService = nlpService;
    }

    @Override
    public List<Result> search(String searchString) throws IOException {
        String namedEntityRecognition = nlpService.getNamedEntityRecognition(searchString);
        List<Result> results = new ArrayList<>();
        Customsearch.Cse.List list = customsearch.cse().list(searchString).

        list.setKey(key);
        list.setCx(projetc);

        for(long i = 1 ; i < numOfResults ; i+=10){
            list.setStart(i);
            results.addAll(list.execute().getItems());
        }

        return results;
    }

}
