package org.bhavesh.microservices.breweryclient.client;

import org.bhavesh.microservices.breweryclient.model.BeerDTO;
import org.bhavesh.microservices.breweryclient.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "mssc.brewery")
public class BreweryClient {
    private String apiHost;
    public final String BEER_PATH_V1="/api/v1/beer/";
    public final String CUSTOMER_PATH_V1="/api/v1/customer/";
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

    public URI saveNewBeer(BeerDTO beer)
    {
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1,beer );
    }
    public void updateBeer(UUID id,BeerDTO beer)
    {
        restTemplate.put(apiHost+BEER_PATH_V1+id,beer);
    }
    public void deleteBeer(UUID id)
    {
        restTemplate.delete(apiHost+BEER_PATH_V1+id);
    }
    public CustomerDTO getCustomerById(UUID id)
    {
        return restTemplate.getForObject(apiHost+CUSTOMER_PATH_V1+id,CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customer)
    {
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1,customer );
    }
    public void updateCustomer(UUID id,CustomerDTO customer)
    {
        restTemplate.put(apiHost+CUSTOMER_PATH_V1+id,customer);
    }
    public void deleteCustomer(UUID id)
    {
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+id);
    }

}
