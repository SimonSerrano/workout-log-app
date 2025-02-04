package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;


/**
 * Request to create a trained exercise in a repository.
 *
 * @param log      the workout log to associate with
 * @param exercise the exercise to associate with
 */
public record CreateTrainedExerciseRepoRequest(
    WorkoutLog log,
    Exercise exercise) {

}
