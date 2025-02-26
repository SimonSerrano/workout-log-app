package com.marmouset.workout.app.progression.entity;

import java.time.Instant;

public interface TotalNumberOfRepetitionsRecordFactory {
  TotalNumberOfRepetitionsRecord create(Instant date, Integer reps);
}
