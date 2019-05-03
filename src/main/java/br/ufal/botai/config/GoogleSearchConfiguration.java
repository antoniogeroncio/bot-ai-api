package br.ufal.botai.config;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleSearchConfiguration {

    @Bean
    public Customsearch customsearch(){
        return new Customsearch.Builder(new NetHttpTransport(), new JacksonFactory(), null)
            .setApplicationName("chatterbot ia").build();
    }
}
