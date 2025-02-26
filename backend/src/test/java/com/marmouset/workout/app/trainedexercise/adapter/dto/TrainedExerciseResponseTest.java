package com.marmouset.workout.app.trainedexercise.adapter.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class TrainedExerciseResponseTest {

  @Test
  void shouldThrowNullPointerExceptionWhenIdIsNull() {
    assertThrows(NullPointerException.class, () -> new TrainedExerciseResponse(
        null,
        UUID.randomUUID(),
        new ExerciseResponse("Pull ups"),
        Collections.emptyList(),
        9
    ));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenLogIdIsNull() {
    assertThrows(NullPointerException.class, () -> new TrainedExerciseResponse(
        new Random().nextLong(),
        null,
        new ExerciseResponse("Pull ups"),
        Collections.emptyList(),
        9
    ));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenExerciseResponseIsNull() {
    assertThrows(NullPointerException.class, () -> new TrainedExerciseResponse(
        new Random().nextLong(),
        UUID.randomUUID(),
        null,
        Collections.emptyList(),
        9
    ));
  }

  @Test
  void shouldSetEmptyListWhenSetsIsNull() {
    var response = new TrainedExerciseResponse(
        new Random().nextLong(),
        UUID.randomUUID(),
        new ExerciseResponse("Pull ups"),
        null,
        9
    );

    assertTrue(response.sets().isEmpty());
  }
}