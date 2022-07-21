package org.bhavesh.microservices.breweryclient.client;

import org.bhavesh.microservices.breweryclient.model.BeerDTO;
import org.bhavesh.microservices.breweryclient.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById()
    {
        BeerDTO beerDTO=breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDTO);
    }

    @Test
    void saveBeer()
    {
        BeerDTO beerDTO= BeerDTO.builder().build();
        URI uri=breweryClient.saveNewBeer(beerDTO);
        assertNotNull(uri);
        System.out.println(uri);
    }
    @Test
    void updateBeer()
    {
        BeerDTO beerDTO= BeerDTO.builder().build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDTO);
    }
    @Test
    void deleteBeer()
    {
        BeerDTO beerDTO= BeerDTO.builder().build();
        breweryClient.deleteBeer(UUID.randomUUID());
    }
    @Test
    void getCustomerById()
    {
        CustomerDTO customerDTO=breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void saveCustomer()
    {
        CustomerDTO customerDTO= CustomerDTO.builder().build();
        URI uri=breweryClient.saveNewCustomer(customerDTO);
        assertNotNull(uri);
        System.out.println(uri);
    }
    @Test
    void updateCustomer()
    {
        CustomerDTO customerDTO= CustomerDTO.builder().build();
        breweryClient.updateCustomer(UUID.randomUUID(),customerDTO);
    }
    @Test
    void deleteCustomer()
    {
        CustomerDTO customerDTO= CustomerDTO.builder().build();
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}