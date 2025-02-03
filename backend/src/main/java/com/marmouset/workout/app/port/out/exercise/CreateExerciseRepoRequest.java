package com.marmouset.workout.app.port.out.exercise;

/**
 * Record to create an exercise in a repo.
 *
 * @param name the name of the exercise
 */
public record CreateExerciseRepoRequest(String name) {

}
