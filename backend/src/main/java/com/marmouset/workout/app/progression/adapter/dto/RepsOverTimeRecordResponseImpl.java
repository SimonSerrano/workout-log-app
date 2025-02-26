package com.marmouset.workout.app.progression.adapter.dto;

import com.marmouset.workout.app.progression.adapter.RepsOverTimeRecordResponse;

public record RepsOverTimeRecordResponseImpl(
    Long timestamp,
    Integer reps)
    implements RepsOverTimeRecordResponse {
}
