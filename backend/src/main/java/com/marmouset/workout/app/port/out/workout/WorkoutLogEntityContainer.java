package com.marmouset.workout.app.port.out.workout;

import com.marmouset.workout.app.port.out.EntityContainer;
import java.util.UUID;

/**
 * Interface representing the container for a workout log entity.
 */
public interface WorkoutLogEntityContainer
    extends EntityContainer<UUID, WorkoutLogEntity> {
}
