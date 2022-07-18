package org.bhavesh.microservices.breweryclient.client;

import org.bhavesh.microservices.breweryclient.model.BeerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "mssc.brewery")
public class BreweryClient {
    private String apiHost;
    public final String BEER_PATH_V1="/api/v1/beer/";
    public final String BEER_PATH_V2="/api/v2/beer/";
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID id)
    {
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+id,BeerDTO.class);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
