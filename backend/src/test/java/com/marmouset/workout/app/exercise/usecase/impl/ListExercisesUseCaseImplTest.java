package com.marmouset.workout.app.exercise.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListExercisesUseCaseImplTest {

  private ExerciseRepository repository;

  private ListExercisesUseCaseImpl useCase;


  @BeforeEach
  void setUp() {
    repository = mock(ExerciseRepository.class);
    useCase = new ListExercisesUseCaseImpl(repository);
  }

  @Test
  void shouldReturnListOfExercises() {
    var exercise1 = new ExerciseTestDouble();
    var exercise2 = new ExerciseTestDouble();

    doReturn(List.of(
        exercise1,
        exercise2
    )).when(repository).read();


    var result = useCase.list().iterator();
    assertEquals(exercise1, result.next());
    assertEquals(exercise2, result.next());

  }

  @Test
  void shouldReturnEmpty() {
    when(repository.read()).thenReturn(Collections.emptyList());
    assertTrue(useCase.list().isEmpty());
  }
}