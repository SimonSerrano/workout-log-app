package com.marmouset.workout.app.port.out.exercise.trained;

/**
 * Record to request the deletion of a trained exerciseContainer.
 *
 * @param trainedId the trained id
 */
public record DeleteTrainedExerciseRepoRequest(Long trainedId) {
}
