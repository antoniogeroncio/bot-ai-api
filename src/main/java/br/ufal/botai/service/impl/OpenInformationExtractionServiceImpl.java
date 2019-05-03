package br.ufal.botai.service.impl;

import br.ufal.botai.service.OpenInformationExtractionService;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class OpenInformationExtractionServiceImpl implements OpenInformationExtractionService {
    @Override
    public String extract(String text) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        CoreDocument document = new CoreDocument(text);
        pipeline.annotate(document);
        StringBuilder searchText = new StringBuilder();
        String conector = "";
        for (CoreEntityMention em : document.entityMentions()) {
            searchText.append(conector);
            searchText.append("'" +em.text()+"'");
            conector = "%20AND%20";
        }
        return searchText.toString();
    }
}
