package com.marmouset.workout.domain;

import java.util.UUID;

public record WorkoutLogListElementDTO(UUID id, String title, Long createdAtTimestamp) {

}
