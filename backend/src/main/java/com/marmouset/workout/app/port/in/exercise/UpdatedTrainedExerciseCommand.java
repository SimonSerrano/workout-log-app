package com.marmouset.workout.app.port.in.exercise;

import java.util.List;
import java.util.UUID;

/**
 * DTO for updating a trained exerciseContainer.
 *
 * @param trainedId  the trained exerciseContainer id
 * @param logId      the logContainer id
 * @param exerciseId the new exerciseContainer id
 * @param sets       the number of repetitions during that set
 */
public record UpdatedTrainedExerciseCommand(
    long trainedId,
    UUID logId,
    String exerciseId,
    List<Integer> sets
) {
}
