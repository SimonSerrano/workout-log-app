package com.marmouset.workout.app.exerciseset.adapter.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import org.junit.jupiter.api.Test;

class ExerciseSetResponseTest {

  @Test
  void shouldThrowNullPointerExceptionWhenIdIsNull() {
    assertThrows(NullPointerException.class,
        () -> new ExerciseSetResponse(null, 9));
  }

  @Test
  void shouldThrowNullPointerExceptionWhenRepsIsNull() {
    assertThrows(NullPointerException.class,
        () -> new ExerciseSetResponse(3L, null));
  }
}