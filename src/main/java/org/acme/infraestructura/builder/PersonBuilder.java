package org.acme.infraestructura.builder;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.infraestructura.PersonEntity;
import org.acme.model.User;

@ApplicationScoped // Ejemplo de alcance
public class PersonBuilder {
  public PersonEntity builderFromPersonToPersonEntity(User user){
    PersonEntity builderEntity = new PersonEntity();
    builderEntity.setUsername(user.getUsername());
    builderEntity.setFirstName(user.getFirstName());
    builderEntity.setLastName(user.getLastName());
    builderEntity.setUserStatus(user.getUserStatus());
    return builderEntity;
  }

  public User builderFromPersonEntityToPerson(PersonEntity personEntity){
    User user = new User();
    user.setId(personEntity.getId());
    user.setUsername(personEntity.getUsername());
    user.setFirstName(personEntity.getFirstName());
    user.setLastName(personEntity.getLastName());
    user.setUserStatus(personEntity.getUserStatus());
    return user;
  }
}
