package com.marmouset.workout.external.database.workout;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WorkoutLogEntityContainerImplTest {

  @Test
  void shouldThrowNullPointerException() {
    assertThrows(NullPointerException.class,
        () -> new WorkoutLogEntityContainerImpl(null));
  }
}