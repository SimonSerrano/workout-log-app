package com.marmouset.workout.app.port.out.set;

import java.util.UUID;

/**
 * Record for the exercise set.
 *
 * @param id   set id
 * @param reps number of repetition
 */
public record ExerciseSetResponse(UUID id, int reps) {
}
