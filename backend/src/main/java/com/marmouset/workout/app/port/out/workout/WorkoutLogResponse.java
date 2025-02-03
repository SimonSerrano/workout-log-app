package com.marmouset.workout.app.port.out.workout;

import java.util.UUID;


/**
 * Response for the WorkoutLog.
 *
 * @param id                 the id
 * @param name               the name
 * @param createdAtTimestamp the timestamp of creation
 */
public record WorkoutLogResponse(UUID id, String name,
                                 Long createdAtTimestamp) {
}
