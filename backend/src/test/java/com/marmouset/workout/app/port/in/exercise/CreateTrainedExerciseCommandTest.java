package com.marmouset.workout.app.port.in.exercise;

import static org.junit.jupiter.api.Assertions.assertThrows;

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