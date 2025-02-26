package com.marmouset.workout.app.workout.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetLogDetailsUseCaseImplTest {

  private WorkoutLogRepository repository;

  private GetLogDetailsUseCaseImpl useCase;

  @BeforeEach
  void setUp() {
    repository = mock(WorkoutLogRepository.class);
    useCase = new GetLogDetailsUseCaseImpl(repository);
  }

  @Test
  void shouldReturnWorkoutLog() throws NotFoundException,
      WorkoutLogNotFoundException {
    var log = new WorkoutLogTestDouble();
    when(repository.read(log.getId())).thenReturn(log);

    assertEquals(log, useCase.get(log.getId()));
  }

  @Test
  void shouldThrowWorkoutLogNotFound() throws NotFoundException {
    var id = UUID.randomUUID();
    when(repository.read(id)).thenThrow(new NotFoundException());
    assertThrows(WorkoutLogNotFoundException.class,
        () -> useCase.get(id));
  }

}