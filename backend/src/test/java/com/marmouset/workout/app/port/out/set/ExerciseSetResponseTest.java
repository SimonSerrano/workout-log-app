package com.marmouset.workout.app.port.out.set;

import static org.junit.jupiter.api.Assertions.assertThrows;

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