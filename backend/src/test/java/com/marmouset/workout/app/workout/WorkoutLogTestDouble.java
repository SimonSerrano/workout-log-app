package com.marmouset.workout.app.workout;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Workout log test double with static values.
 */
public class WorkoutLogTestDouble implements WorkoutLog {

  private final UUID id = UUID.randomUUID();
  private Instant createdAt = Instant.now();
  private String name = "My Workout";

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Instant getCreatedAt() {
    return createdAt;
  }

  @Override
  public WorkoutLog rename(String name) {
    this.name = name;
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

    WorkoutLogTestDouble that = (WorkoutLogTestDouble) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!Objects.equals(createdAt, that.createdAt)) {
      return false;
    }
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  /**
   * Sets the creation date.
   *
   * @param createdAt the new creation date
   * @return this
   */
  public WorkoutLogTestDouble setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

}
