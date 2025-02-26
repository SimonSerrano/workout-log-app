package com.marmouset.workout.app.exercise.usecase.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CreateExerciseRepoRequestTest {
  @Test
  void shouldThrowNullPointerExceptionWhenNameIsNull() {
    assertThrows(NullPointerException.class,
        () -> new CreateExerciseRepoRequest(null));
  }
}