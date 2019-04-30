package br.ufal.botai.service;

import com.google.api.services.customsearch.model.Result;

import java.io.IOException;
import java.util.List;

public interface GoogleSearchService {
    List<Result> search(String searchString) throws IOException;
}
