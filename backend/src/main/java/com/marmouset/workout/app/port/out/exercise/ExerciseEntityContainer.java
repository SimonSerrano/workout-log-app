package com.marmouset.workout.app.port.out.exercise;

import com.marmouset.workout.app.port.out.EntityContainer;
import java.util.UUID;

/**
 * Interface representing a container for an exercise entity.
 */
public interface ExerciseEntityContainer
    extends EntityContainer<UUID, ExerciseEntity> {
}
