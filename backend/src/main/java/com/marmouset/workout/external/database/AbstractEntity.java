package com.marmouset.workout.external.database;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import java.time.Instant;

/**
 * Entity for the database that adds id and date time events.
 */
@MappedSuperclass
public abstract class AbstractEntity {


  @Version
  private Integer version;

  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  @Column(nullable = false)
  private Instant updatedAt;

  /**
   * Sets the createdAt and updatedAt.
   */
  @PrePersist
  protected void onCreate() {
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
  }

  /**
   * Updates the updatedAt.
   */
  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = Instant.now();
  }

  public Integer getVersion() {
    return version;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }
}
