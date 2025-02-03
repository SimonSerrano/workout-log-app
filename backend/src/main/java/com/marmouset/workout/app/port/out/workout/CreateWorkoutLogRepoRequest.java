package com.marmouset.workout.app.port.out.workout;

/**
 * Record to create a workout log in a repository.
 *
 * @param name the name of the workout
 */
public record CreateWorkoutLogRepoRequest(String name) {

}
