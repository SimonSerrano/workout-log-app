package com.marmouset.workout.app.port.in.workout;

import java.util.UUID;

public record UpdateWorkoutLogCommand(UUID id, String name) {
}
