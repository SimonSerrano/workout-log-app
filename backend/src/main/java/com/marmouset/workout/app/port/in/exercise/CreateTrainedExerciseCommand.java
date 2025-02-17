package com.marmouset.workout.app.port.in.exercise;

import java.util.UUID;

/**
 * DTO to create a trained exerciseContainer in the business layer.
 *
 * @param logId      the logContainer id
 * @param exerciseId the exerciseContainer id
 */
public record CreateTrainedExerciseCommand(UUID logId, UUID exerciseId) {
}
