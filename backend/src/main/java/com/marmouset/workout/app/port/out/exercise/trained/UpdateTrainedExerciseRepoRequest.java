package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;

/**
 * DTO to update a trained exercise.
 *
 * @param trainedId         the trained exercise id
 * @param exerciseContainer the exercise container with the exercise trained
 */
public record UpdateTrainedExerciseRepoRequest(
    Long trainedId,
    ExerciseEntityContainer exerciseContainer) {
}
