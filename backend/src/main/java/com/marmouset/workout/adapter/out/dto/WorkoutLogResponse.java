package com.marmouset.workout.adapter.out.dto;

import java.util.UUID;

public record WorkoutLogResponse(UUID id, String title, Long createdAtTimestamp) {

}
