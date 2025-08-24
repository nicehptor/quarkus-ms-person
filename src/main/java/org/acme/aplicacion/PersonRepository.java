package org.acme.aplicacion;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.infraestructura.PersonEntity;


@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonEntity> {
  @Transactional
  public PersonEntity save(PersonEntity personEntity) {
    // Persistir el usuario
    persist(personEntity);

    // Devolver el usuario guardado (ahora con ID generado)
    return personEntity;
  }

  @Transactional
  public long deleteByUserName(String username) {
    // Eliminar por nombre de usuario y retornar el número de entidades eliminadas
    return delete("username", username);
  }

  @Transactional
  public PersonEntity findByUserName(String username) {
    return find("username", username).firstResult();
  }
}
