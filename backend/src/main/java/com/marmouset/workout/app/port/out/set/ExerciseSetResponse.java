package com.marmouset.workout.app.port.out.set;

/**
 * Record for the exerciseContainer set.
 *
 * @param id   set id
 * @param reps number of repetition
 */
public record ExerciseSetResponse(Long id, int reps) {
}
