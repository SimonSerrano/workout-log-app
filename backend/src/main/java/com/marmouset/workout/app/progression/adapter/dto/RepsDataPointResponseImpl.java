package com.marmouset.workout.app.progression.adapter.dto;

import com.marmouset.workout.app.progression.adapter.RepsDataPointResponse;

/**
 * Implementation of the reps data point response.
 */
public record RepsDataPointResponseImpl(
                Long timestamp,
                Integer reps)
                implements RepsDataPointResponse {
}
