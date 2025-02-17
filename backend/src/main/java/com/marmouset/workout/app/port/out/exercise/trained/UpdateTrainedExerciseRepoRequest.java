package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import java.util.UUID;

/**
 * DTO to update a trained exercise.
 *
 * @param trainedId         the trained exercise id
 * @param logId             the workout log id
 * @param exerciseContainer the exercise container with the exercise trained
 */
public record UpdateTrainedExerciseRepoRequest(
    Long trainedId,
    UUID logId,
    ExerciseEntityContainer exerciseContainer) {
}
