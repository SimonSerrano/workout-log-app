package com.marmouset.workout.app.progression.adapter.dto;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.progression.adapter.RepsDataPointResponse;
import com.marmouset.workout.app.progression.adapter.RepsProgressionChartResponse;
import java.util.List;

/**
 * Implementation of the reps progression chart response.
 */
public record RepsProgressionChartResponseImpl(
        ExerciseResponse exercise,
        List<? extends RepsDataPointResponse> chart)
        implements RepsProgressionChartResponse {
}
