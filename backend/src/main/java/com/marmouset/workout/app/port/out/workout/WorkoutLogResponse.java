package com.marmouset.workout.app.port.out.workout;

import java.util.UUID;

public class WorkoutLogResponse {
  private final UUID id;
  private final String title;
  private final Long createAtTimestamp;

  public WorkoutLogResponse(UUID id, String title, Long createdAtTimestamp) {
    this.id = id;
    this.title = title;
    this.createAtTimestamp = createdAtTimestamp;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Long getCreateAtTimestamp() {
    return createAtTimestamp;
  }

}
