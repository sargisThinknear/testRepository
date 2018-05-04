package org.jug.algeria.controller;


import org.assertj.core.api.Assertions;
import org.jug.algeria.domain.MyItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.yml"})
public class HomeControllerIntegrationTests {

  RestTemplate restTemplate = new RestTemplate();

  @Test
  public void shouldAdd_AppUser_ToDb() {

    ResponseEntity<MyItem> responseEntity = restTemplate
      .postForEntity("http://localhost:9000/myItemRepository/Abderrazak BOUADMA",
        MockHttpServletRequest.DEFAULT_PROTOCOL,
        MyItem.class);

    final MyItem myItem = responseEntity.getBody();

    Assertions.assertThat(myItem).isNotNull();
    Assertions.assertThat(myItem.getName()).isNotNull().isEqualTo("Abderrazak BOUADMA");
  }
}
