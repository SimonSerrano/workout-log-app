package com.marmouset.workout.adapter.out.dto;

import java.util.UUID;

public record WorkoutLogListElementResponse(UUID id, String title, Long createdAtTimestamp) {

}
