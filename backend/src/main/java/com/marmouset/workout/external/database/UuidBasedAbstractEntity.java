package com.marmouset.workout.external.database;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * Class to create abstract entities with an uuid based id.
 */
@MappedSuperclass
public abstract class UuidBasedAbstractEntity
    extends AbstractEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  public UUID getId() {
    return id;
  }

  public UuidBasedAbstractEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UuidBasedAbstractEntity that = (UuidBasedAbstractEntity) o;

    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
