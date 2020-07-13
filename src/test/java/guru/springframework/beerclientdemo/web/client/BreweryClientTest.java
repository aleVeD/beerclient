package guru.springframework.beerclientdemo.web.client;

import guru.springframework.beerclientdemo.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient client;


  @Test
  void getBeerById() {
    BeerDto dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void savedNewBeer() {
    BeerDto dto = BeerDto.builder().beerName("Corona").build();
    URI uri = client.savedNewBeer(dto);
    assertNotNull(uri);
    System.out.println("uri.toString() = " + uri.toString());
  }
}