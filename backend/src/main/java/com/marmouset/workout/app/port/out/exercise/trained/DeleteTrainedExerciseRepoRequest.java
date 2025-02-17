package com.marmouset.workout.app.port.out.exercise.trained;

import java.util.UUID;

/**
 * Record to request the deletion of a trained exerciseContainer.
 *
 * @param logId     the logContainer id
 * @param trainedId the trained id
 */
public record DeleteTrainedExerciseRepoRequest(UUID logId, Long trainedId) {
}
