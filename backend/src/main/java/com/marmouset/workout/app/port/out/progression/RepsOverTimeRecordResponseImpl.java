package com.marmouset.workout.app.port.out.progression;

public record RepsOverTimeRecordResponseImpl(
    Long timestamp,
    Integer reps)
    implements RepsOverTimeRecordResponse {
}
