package com.marmouset.workout.app.workout.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListWorkoutLogsUseCaseImplTest {

  private WorkoutLogRepository repository;


  private ListWorkoutLogsUseCaseImpl useCase;

  @BeforeEach
  void setUp() {
    repository = mock(WorkoutLogRepository.class);
    useCase = new ListWorkoutLogsUseCaseImpl(repository);
  }

  @Test
  void shouldReturnWorkoutLogs() {
    var log1 = new WorkoutLogTestDouble();
    var log2 = new WorkoutLogTestDouble();

    doReturn(List.of(log1, log2)).when(repository).read();


    var result = useCase.list().iterator();
    assertEquals(log1, result.next());
    assertEquals(log2, result.next());
  }

  @Test
  void shouldReturnEmptyWorkoutLogs() {
    when(repository.read()).thenReturn(Collections.emptyList());
    assertTrue(useCase.list().isEmpty());
  }
}