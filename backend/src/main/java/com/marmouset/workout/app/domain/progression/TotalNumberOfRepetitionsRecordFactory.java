package com.marmouset.workout.app.domain.progression;

import java.time.Instant;

public interface TotalNumberOfRepetitionsRecordFactory {
  TotalNumberOfRepetitionsRecord create(Instant date, Integer reps);
}
