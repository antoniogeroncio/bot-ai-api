package br.ufal.botai.service.impl;

import br.ufal.botai.service.GoogleSearchService;
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

    @Autowired
    public GoogleSearchServiceImpl(Customsearch customsearch) {
        this.customsearch = customsearch;
    }

    @Override
    public String search(String searchString) throws IOException {
        List<Result> results = new ArrayList<>();
        Customsearch.Cse.List list = customsearch.cse().list(searchString);
        list.setKey(key);
        list.setCx(projetc);
        StringBuilder stringBuilder = new StringBuilder();
        for(long i = 1 ; i < numOfResults ; i+=10){
            list.setStart(i);
            List<Result> retorno = list.execute().getItems();
            if(retorno != null){
                for (Result r : retorno) {
                    stringBuilder.append(r.getSnippet() + " ");
                }
            }
        }

        return stringBuilder.toString();
    }

}
