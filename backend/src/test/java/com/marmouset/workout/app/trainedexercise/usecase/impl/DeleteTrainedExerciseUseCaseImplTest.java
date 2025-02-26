package com.marmouset.workout.app.trainedexercise.usecase.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.trainedexercise.usecase.DeleteTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteTrainedExerciseUseCaseImplTest {
  private TrainedExerciseRepository trainedExerciseRepository;
  private WorkoutLogRepository workoutLogRepository;

  private DeleteTrainedExerciseUseCase useCase;

  @BeforeEach
  void setUp() {
    trainedExerciseRepository = mock(TrainedExerciseRepository.class);
    workoutLogRepository = mock(WorkoutLogRepository.class);
    useCase = new DeleteTrainedExerciseUseCaseImpl(trainedExerciseRepository,
        workoutLogRepository);
  }

  @Test
  void shouldCallDeleteRepository() throws WorkoutLogNotFoundException {
    var logId = UUID.randomUUID();
    var trainedId = 7L;
    when(workoutLogRepository.exists(logId)).thenReturn(true);
    useCase.delete(logId, trainedId);
    verify(trainedExerciseRepository, times(1))
        .delete(new DeleteTrainedExerciseRepoRequest(trainedId));
  }
}