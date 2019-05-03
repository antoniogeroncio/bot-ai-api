package br.ufal.botai.service.impl;

import br.ufal.botai.service.NlpService;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class NlpServiceImpl implements NlpService {
    @Override
    public String getNamedEntityRecognition(String searchString) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        CoreDocument document = new CoreDocument(searchString);
        pipeline.annotate(document);
        // get confidences for entities
        for (CoreEntityMention em : document.entityMentions()) {
            System.out.println(em.text() + "\t" + em.entityTypeConfidences());
        }
        // get confidences for tokens
        for (CoreLabel token : document.tokens()) {
            System.out.println(token.word() + "\t" + token.get(CoreAnnotations.NamedEntityTagProbsAnnotation.class));
        }
        return null;
    }
}
