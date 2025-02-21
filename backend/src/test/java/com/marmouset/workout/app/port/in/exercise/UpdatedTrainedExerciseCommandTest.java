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
        () -> new UpdatedTrainedExerciseCommandBuilder()
            .setTrainedId(null)
            .setLogId(UUID.randomUUID())
            .setExerciseId("Pull ups")
            .setSets(Collections.emptyList())
            .setWeight(null)
            .build());
  }

  @Test
  void shouldThrowNullPointerExceptionWhenLogIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new UpdatedTrainedExerciseCommandBuilder()
            .setTrainedId(new Random().nextLong())
            .setLogId(null)
            .setExerciseId("Pull ups")
            .setSets(Collections.emptyList())
            .setWeight(null)
            .build());
  }

  @Test
  void shouldThrowNullPointerExceptionWhenExerciseIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new UpdatedTrainedExerciseCommandBuilder()
            .setTrainedId(new Random().nextLong())
            .setLogId(UUID.randomUUID())
            .setExerciseId(null)
            .setSets(null)
            .setWeight(null)
            .build());
  }
}