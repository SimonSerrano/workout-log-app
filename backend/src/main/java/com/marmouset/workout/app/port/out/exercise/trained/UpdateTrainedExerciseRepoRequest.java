package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import java.util.List;

/**
 * DTO to update a trained exercise.
 *
 * @param trainedId         the trained exercise id
 * @param exerciseContainer the exercise container with the exercise trained
 * @param sets              the repetitions
 */
public record UpdateTrainedExerciseRepoRequest(
    Long trainedId,
    ExerciseEntityContainer exerciseContainer,
    List<Integer> sets) {
}
