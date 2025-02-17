package com.marmouset.workout.app.port.in.workout;

import java.util.UUID;

/**
 * Command to update a workout logContainer.
 *
 * @param id   the id of the workout
 * @param name the name to update
 */
public record UpdateWorkoutLogCommand(UUID id, String name) {
}
