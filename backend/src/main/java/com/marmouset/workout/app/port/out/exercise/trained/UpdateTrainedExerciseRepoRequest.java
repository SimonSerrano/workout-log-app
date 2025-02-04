package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;

/**
 * DTO to update a trained exercise.
 *
 * @param trainedId the trained exercise id
 * @param log       the log the trained exercise belongs to
 * @param exercise  the new exercise
 */
public record UpdateTrainedExerciseRepoRequest(
    Long trainedId,
    WorkoutLog log,
    Exercise exercise) {
}
