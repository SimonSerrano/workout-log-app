package com.marmouset.workout.app.progression.entity.impl;

import com.marmouset.workout.app.progression.entity.TotalNumberOfRepetitionsRecord;
import java.time.Instant;

public record TotalNumberOfRepetitionsRecordImpl(
    Instant date,
    Integer reps) implements TotalNumberOfRepetitionsRecord {

}
