package com.marmouset.workout.app.exercise.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.adapter.ExerciseResponsePresenter;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExerciseResponsePresenterImplTest {

  private ExerciseResponsePresenter presenter;

  @BeforeEach
  void setUp() {
    presenter = new ExerciseResponsePresenterImpl();
  }

  @Test
  void shouldThrowNullPointerExceptionIfExerciseIsNull() {
    assertThrows(NullPointerException.class, () -> presenter.present(null));
  }

  @Test
  void shouldMapToResponse() {
    assertEquals(
        new ExerciseResponse("Pull ups"),
        presenter.present(new ExerciseTestDouble()));
  }
}