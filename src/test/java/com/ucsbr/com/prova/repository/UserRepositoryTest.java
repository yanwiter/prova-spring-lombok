package com.ucsbr.com.prova.repository;

import com.ucsbr.com.prova.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  private static final String EMAIL = "samuluc1@gmail.com";

  @Autowired
  UserRepository repository;

  @Before
  public void setUp(){
    User u = new User();
    u.setEmail("samuluc1@gmail.com");
    u.setLogin("samuluc");
    u.setPassword("1234");
    u.setNome("Samuel Luciano de Souza");
    repository.save(u);
  }

  @After
  public void tearDown(){
    repository.deleteAll();
  }

  @Test
  public void testSave(){
    User u = new User();
    u.setEmail("jhon@net.com");
    u.setLogin("jhon");
    u.setPassword("1234");
    u.setNome("Jhon Doe");

    User response = repository.save(u);

    assertNotNull(response);

  }

  @Test
  public void testFindEmail(){
    Optional<User> response = repository.findByEmailEquals(EMAIL);
    assertTrue(response.isPresent());
    assertEquals(response.get().getEmail(), EMAIL);
  }


}
