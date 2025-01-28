package com.marmouset.workout.app.port.in;

import java.util.UUID;

public interface DeleteWorkoutLogPort {
  void deleteWorkoutLog(UUID uuid);
}
