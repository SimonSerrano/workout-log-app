package com.marmouset.workout.app.domain.progression.impl;

import java.time.Instant;
import com.marmouset.workout.app.domain.progression.TotalNumberOfRepetitionsRecord;

public record TotalNumberOfRepetitionsRecordImpl(
    Instant date,
    Integer reps) implements TotalNumberOfRepetitionsRecord {

}
