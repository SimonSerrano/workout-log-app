package com.marmouset.workout.app.port.out.exercise;

/**
 * Record to create an exerciseContainer in a repo.
 *
 * @param name the name of the exerciseContainer
 */
public record CreateExerciseRepoRequest(String name) {

}
