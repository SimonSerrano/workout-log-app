package com.marmouset.workout.external.web.workout;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
record CreateOrUpdateWorkoutLogBody(
    @NotBlank(message = "Name is mandatory") String name) {

}
