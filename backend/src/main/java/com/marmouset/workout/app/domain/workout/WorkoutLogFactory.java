package com.marmouset.workout.app.domain.workout;

import java.time.Instant;
import java.util.UUID;

public interface WorkoutLogFactory {
  WorkoutLog create(UUID id, String name, Instant createdAt);
}
