package com.marmouset.workout.app.port.in.exercise;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UpdatedTrainedExerciseCommandTest {

  @Test
  void shouldThrowNullPointerExceptionWhenTrainedIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new UpdatedTrainedExerciseCommand(
            null,
            UUID.randomUUID(),
            "Pull ups",
            Collections.emptyList()));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenLogIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new UpdatedTrainedExerciseCommand(
            new Random().nextLong(),
            null,
            "Pull ups",
            Collections.emptyList()));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenExerciseIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new UpdatedTrainedExerciseCommand(
            new Random().nextLong(),
            UUID.randomUUID(),
            null,
            Collections.emptyList()));
  }
}