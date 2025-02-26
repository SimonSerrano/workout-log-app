package com.marmouset.workout.app.exercise.adapter.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExerciseResponseTest {

  @Test
  void shouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> new ExerciseResponse(null));
  }
}