package com.marmouset.workout.app.progression.entity.impl;

import com.marmouset.workout.app.progression.entity.RepsDataPoint;
import java.time.Instant;

/**
 * Implementation of a reps data doint.
 */
public record RepsDataPointImpl(
    Instant date,
    Integer reps) implements RepsDataPoint {
}
