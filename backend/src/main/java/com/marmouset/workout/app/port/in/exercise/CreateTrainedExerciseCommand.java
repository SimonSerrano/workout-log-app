package com.marmouset.workout.app.port.in.exercise;

import java.util.List;
import java.util.UUID;

/**
 * DTO to create a trained exerciseContainer in the business layer.
 *
 * @param logId      the logContainer id
 * @param exerciseId the exerciseContainer id
 * @param sets       the sets practiced
 */
public record CreateTrainedExerciseCommand(
    UUID logId,
    UUID exerciseId,
    List<Integer> sets) {
}
