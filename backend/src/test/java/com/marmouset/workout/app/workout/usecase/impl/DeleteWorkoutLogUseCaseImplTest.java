package com.marmouset.workout.app.workout.usecase.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DeleteWorkoutLogUseCaseImplTest {

  private WorkoutLogRepository repository;

  private DeleteWorkoutLogUseCaseImpl useCase;

  @BeforeEach
  void setUp() {
    repository = mock(WorkoutLogRepository.class);
    useCase = new DeleteWorkoutLogUseCaseImpl(repository);
  }

  @Test
  void shouldCallRepository() {
    var id = UUID.randomUUID();
    useCase.delete(id);
    verify(repository, times(1)).delete(id);
  }
}