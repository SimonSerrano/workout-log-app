package com.marmouset.workout.app.port.in.exercise;

import java.util.UUID;

/**
 * DTO for updating a trained exercise.
 *
 * @param trainedId  the trained exercise id
 * @param logId      the log id
 * @param exerciseId the new exercise id
 */
public record UpdatedTrainedExerciseCommand(long trainedId, UUID logId,
                                            UUID exerciseId) {
}
