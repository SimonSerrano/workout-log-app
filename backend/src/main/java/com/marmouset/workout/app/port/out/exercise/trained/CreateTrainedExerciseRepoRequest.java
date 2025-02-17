package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import java.util.List;


/**
 * Request to create a trained exerciseContainer in a repository.
 *
 * @param logContainer      the workout log container with
 *                          the log entity to associate with
 * @param exerciseContainer the exerciseContainer container
 *                          with the exerciseContainer entity to associate with
 * @param sets              the sets practiced
 */
public record CreateTrainedExerciseRepoRequest(
    WorkoutLogEntityContainer logContainer,
    ExerciseEntityContainer exerciseContainer,
    List<Integer> sets) {

}
