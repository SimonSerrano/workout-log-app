package com.marmouset.workout.app.progression.adapter.dto;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.progression.adapter.RepsOverTimeRecordResponse;
import com.marmouset.workout.app.progression.adapter.RepsOverTimeResponse;
import java.util.List;

public record RepsOverTimeResponseImpl(
    ExerciseResponse exercise,
    List<RepsOverTimeRecordResponse> chart) implements RepsOverTimeResponse {
}
