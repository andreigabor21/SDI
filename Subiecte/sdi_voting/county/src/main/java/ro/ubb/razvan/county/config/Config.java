package ro.ubb.razvan.county.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ro.ubb.razvan.county.server.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Bean
    public Server server() {
        return new Server();
    }
}
