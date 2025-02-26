package com.marmouset.workout.app.exercise.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.adapter.ExerciseController;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exercise.usecase.ListExercisesUseCase;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExerciseControllerImplTest {

  private ExerciseController controller;

  private ListExercisesUseCase listUseCaseMock;

  @BeforeEach
  void setUp() {
    listUseCaseMock = mock(ListExercisesUseCase.class);
    controller = new ExerciseControllerImpl(listUseCaseMock);
  }

  @Test
  void shouldReturnListOfResponse() {
    var expected = List.of(
        new ExerciseResponse("Pull ups"),
        new ExerciseResponse("Pull ups"));

    doReturn(
        List.of(
            new ExerciseTestDouble(),
            new ExerciseTestDouble())
    ).when(listUseCaseMock).list();

    assertEquals(expected, controller.list());
  }
}