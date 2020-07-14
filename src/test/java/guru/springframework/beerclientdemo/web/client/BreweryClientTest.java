package guru.springframework.beerclientdemo.web.client;

import guru.springframework.beerclientdemo.web.model.BeerDto;
import guru.springframework.beerclientdemo.web.model.CustomerDto;
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
  void testSaveNewBeer() {
    //given
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

    URI uri = client.saveNewBeer(beerDto);

    assertNotNull(uri);

    System.out.println(uri.toString());

  }

  @Test
  void updateBeer() {
    BeerDto dto = BeerDto.builder().beerName("Cristal").build();
    client.updateBeer(dto, UUID.randomUUID());
  }

  @Test
  void deleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }

  @Test
  void getCustomerById(){
    CustomerDto dto = client.getCustomerById(UUID.randomUUID());
    assertNotNull(dto);
  }
  @Test
  void testSaveNewCustomer() {
    //given
    CustomerDto customerDto = CustomerDto.builder().name("Joe").build();

    URI uri = client.saveNewCustomer(customerDto);

    assertNotNull(uri);

    System.out.println(uri.toString());

  }

  @Test
  void updateCustomer(){
    CustomerDto dto = CustomerDto.builder().name("Adri").build();
    client.saveUpdate(UUID.randomUUID(), dto);
  }

  @Test
  void deleteCustomer(){
    client.deleteCustomer(UUID.randomUUID());
  }
}