package com.marmouset.workout.app.progression.entity;

import java.time.Instant;

public interface TotalNumberOfRepetitionsRecord {
  Instant date();

  Integer reps();
}
