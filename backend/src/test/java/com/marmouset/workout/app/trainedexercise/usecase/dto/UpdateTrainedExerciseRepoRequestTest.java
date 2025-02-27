package com.marmouset.workout.app.trainedexercise.usecase.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import java.util.Collections;
import java.util.Random;
import org.junit.jupiter.api.Test;

class UpdateTrainedExerciseRepoRequestTest {

  @Test
  void shouldThrowNullPointerExceptionWhenTrainedIdIsNull() {
    assertThrows(
        NullPointerException.class,
        () -> new UpdateTrainedExerciseRepoRequest(
            null,
            new ExerciseTestDouble(),
            Collections.emptyList(),
            null));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenExerciseIsNull() {
    assertThrows(
        NullPointerException.class,
        () -> new UpdateTrainedExerciseRepoRequest(
            new Random().nextLong(),
            null,
            Collections.emptyList(),
            null));
  }

  @Test
  void shouldPopulateSetsWhenSetsIsNull() {
    var request = new UpdateTrainedExerciseRepoRequest(
        new Random().nextLong(),
        new ExerciseTestDouble(),
        null,
        null);
    assertTrue(request.sets().isEmpty());

  }

}
