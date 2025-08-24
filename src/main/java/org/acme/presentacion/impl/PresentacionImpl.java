package org.acme.presentacion.impl;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.acme.api.UserApi;
import org.acme.aplicacion.PersonRepository;
import org.acme.infraestructura.PersonEntity;
import org.acme.infraestructura.builder.PersonBuilder;
import org.acme.model.User;
import org.acme.utils.Constants;
import java.util.Map;

public class PresentacionImpl implements UserApi {

  @Inject
  PersonRepository personRepository;

  @Inject
  PersonBuilder personBuilder;
  /**
   * @param user
   * @return
   */
  @Override
  public User createUser(User user) {
    if(user.getUserStatus() != null) {
      return personBuilder.builderFromPersonEntityToPerson(
          personRepository.save(
              personBuilder.builderFromPersonToPersonEntity(user)));
    } else{
      throw new WebApplicationException(
          Response.status(Response.Status.TOO_MANY_REQUESTS)
              .entity(Map.of("error", Constants.MESSAGE))
              .build()
      );
    }
  }

  /**
   * @param username
   */
  @Override
  public void deleteUser(String username) {
    if (username != null || !username.isEmpty()){
      personRepository.deleteByUserName(username);
    }
    else{
      throw new WebApplicationException(
          Response.status(Response.Status.TOO_MANY_REQUESTS)
              .entity(Map.of("error", Constants.MESSAGE))
              .build()
      );
    }
  }


  /**
   * @param username
   * @return
   */
  @Override
  public User getUserByName(String username) {
    PersonEntity personEntity = personRepository.findByUserName(username);
    if (personEntity == null) {
      throw new NotFoundException("User not found");
    }
    return personBuilder.builderFromPersonEntityToPerson(personEntity);
  }

  /**
   * @param username
   * @param user
   */
  @Override
  public void updateUser(String username, User user) {

  }
}
