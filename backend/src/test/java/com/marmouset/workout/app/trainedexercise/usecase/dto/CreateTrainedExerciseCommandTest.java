package com.marmouset.workout.app.trainedexercise.usecase.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommand;
import java.util.Collections;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CreateTrainedExerciseCommandTest {


  @Test
  void shouldThrowNullPointerExceptionWhenLogIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new CreateTrainedExerciseCommand(
            null,
            "Pull ups",
            Collections.emptyList(),
            30));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenExerciseIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new CreateTrainedExerciseCommand(
            UUID.randomUUID(),
            null,
            Collections.emptyList(),
            30));
  }
}