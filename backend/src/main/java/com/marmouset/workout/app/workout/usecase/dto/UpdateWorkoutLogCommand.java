package com.marmouset.workout.app.workout.usecase.dto;

import java.util.UUID;

/**
 * Command to update a workout logContainer.
 *
 * @param id   the id of the workout
 * @param name the name to update
 */
public record UpdateWorkoutLogCommand(UUID id, String name) {
}
