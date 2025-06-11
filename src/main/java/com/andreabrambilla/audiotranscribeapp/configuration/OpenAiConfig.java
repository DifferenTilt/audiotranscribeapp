package com.andreabrambilla.audiotranscribeapp.configuration;

import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Value("${spring.ai.openai.api-key}")  // read from application.properties
    private String apiKey;                 // inject in the string

    @Bean
    public OpenAiAudioApi openAiAudioApi() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API-key could not be null!");
        }
        return OpenAiAudioApi.builder()
                .apiKey(apiKey)
                .build();
    }
}
