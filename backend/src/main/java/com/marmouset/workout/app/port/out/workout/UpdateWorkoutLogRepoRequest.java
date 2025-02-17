package com.marmouset.workout.app.port.out.workout;

import java.util.UUID;

/**
 * Request to update a workout logContainer.
 *
 * @param id   the id of the workout to update
 * @param name the new name
 */
public record UpdateWorkoutLogRepoRequest(UUID id, String name) {
}
