package com.marmouset.workout.app.domain.progression;

import java.time.Instant;

public interface TotalNumberOfRepetitionsRecord {
  Instant date();

  Integer reps();
}
