package org.acme.presentacion.impl;

import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.acme.api.UserApi;
import org.acme.aplicacion.PersonRepository;
import org.acme.infraestructura.builder.PersonBuilder;
import org.acme.model.User;
import org.acme.utils.Constants;

import java.util.List;
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
    if(user.getUserStatus() != null)
      return personBuilder.builderFromUserToUserEntity(
          personRepository.save(
              personBuilder.builderFromUserEntityToUser(user)));

    else{
      throw new WebApplicationException(
          Response.status(Response.Status.TOO_MANY_REQUESTS)
              .entity(Map.of("error", Constants.MESSAGE))
              .build()
      );
    }
  }

  /**
   * @param user
   * @return
   */
  @Override
  public User createUsersWithListInput(List<User> user) {
    return null;
  }

  /**
   * @param username
   */
  @Override
  public void deleteUser(String username) {

  }

  /**
   * @param username
   * @return
   */
  @Override
  public User getUserByName(String username) {
    return null;
  }

  /**
   * @param username
   * @param user
   */
  @Override
  public void updateUser(String username, User user) {

  }
}
