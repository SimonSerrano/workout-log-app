package com.marmouset.workout.app.trainedexercise.usecase.dto;

/**
 * Record to request the deletion of a trained exerciseContainer.
 *
 * @param trainedId the trained id
 */
public record DeleteTrainedExerciseRepoRequest(Long trainedId) {
}
