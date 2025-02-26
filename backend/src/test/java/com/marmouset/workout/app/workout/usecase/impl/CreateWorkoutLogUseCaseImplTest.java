package com.marmouset.workout.app.workout.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.entity.WorkoutLogFactory;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogRepoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateWorkoutLogUseCaseImplTest {
  private WorkoutLogRepository repository;


  private CreateWorkoutLogUseCaseImpl useCase;

  private WorkoutLogFactory factory;

  @BeforeEach
  void setUp() {
    repository = mock(WorkoutLogRepository.class);
    useCase = new CreateWorkoutLogUseCaseImpl(repository);
  }

  @Test
  void shouldCreateAndReturnWorkoutLog() {
    var created = new WorkoutLogTestDouble();
    when(repository.create(
        new CreateWorkoutLogRepoRequest(created.getName())))
        .thenReturn(created);
    var result = useCase.create(
        new CreateWorkoutLogCommand(created.getName()));
    assertEquals(created, result);
  }
}