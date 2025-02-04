package com.marmouset.workout.app.port.in.exercise;

import java.util.UUID;

/**
 * DTO to create a trained exercise in the business layer.
 *
 * @param logId      the log id
 * @param exerciseId the exercise id
 */
public record CreateTrainedExerciseCommand(UUID logId, UUID exerciseId) {
}
