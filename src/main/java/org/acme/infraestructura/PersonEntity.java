package org.acme.infraestructura;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="username")
  private String username;
  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;
  @Column(name="user_status")
  private Integer userStatus;
}
