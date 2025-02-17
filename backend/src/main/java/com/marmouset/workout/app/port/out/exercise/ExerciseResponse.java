package com.marmouset.workout.app.port.out.exercise;

import java.util.UUID;

/**
 * Record representing the response.
 *
 * @param id   the id of the exerciseContainer
 * @param name its name
 */
public record ExerciseResponse(UUID id, String name) {
}
