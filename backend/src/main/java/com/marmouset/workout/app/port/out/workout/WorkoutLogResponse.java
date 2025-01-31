package com.marmouset.workout.app.port.out.workout;

import java.util.UUID;

/**
 * Response for the WorkoutLog.
 */
public class WorkoutLogResponse {
  private final UUID id;
  private final String name;
  private final Long createAtTimestamp;

  /**
   * Creates a WorkoutLogResponse.
   *
   * @param id                 the id of the log
   * @param name               the name
   * @param createdAtTimestamp the timestamp
   */
  public WorkoutLogResponse(UUID id, String name, Long createdAtTimestamp) {
    this.id = id;
    this.name = name;
    this.createAtTimestamp = createdAtTimestamp;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getCreateAtTimestamp() {
    return createAtTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WorkoutLogResponse that = (WorkoutLogResponse) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!name.equals(that.name)) {
      return false;
    }
    return createAtTimestamp.equals(that.createAtTimestamp);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + createAtTimestamp.hashCode();
    return result;
  }
}
