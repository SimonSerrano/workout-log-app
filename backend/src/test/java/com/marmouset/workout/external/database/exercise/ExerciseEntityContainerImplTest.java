package com.marmouset.workout.external.database.exercise;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExerciseEntityContainerImplTest {

  @Test
  void shouldThrowNullPointerException() {
    assertThrows(NullPointerException.class,
        () -> new ExerciseEntityContainerImpl(null));
  }
}