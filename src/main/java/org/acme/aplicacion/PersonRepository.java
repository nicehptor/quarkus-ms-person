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
}
