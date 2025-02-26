package com.marmouset.workout.app.trainedexercise.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.TrainedExerciseTestDouble;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.UpdateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpdateTrainedExerciseUseCaseImplTest {

  private TrainedExerciseRepository trainedExerciseRepository;
  private WorkoutLogRepository workoutLogRepository;
  private ExerciseRepository exerciseRepository;

  private UpdateTrainedExerciseUseCase useCase;

  @BeforeEach
  void setUp() {
    trainedExerciseRepository = mock(TrainedExerciseRepository.class);
    workoutLogRepository = mock(WorkoutLogRepository.class);
    exerciseRepository = mock(ExerciseRepository.class);
    useCase = new UpdateTrainedExerciseUseCaseImpl(
        trainedExerciseRepository,
        workoutLogRepository,
        exerciseRepository
    );
  }

  @Test
  void shouldCallRepositoryToUpdateTrainedExercise()
      throws NotFoundException, WorkoutLogNotFoundException,
      ExerciseNotFoundException {
    var trained = new TrainedExerciseTestDouble();

    when(workoutLogRepository.exists(trained.getLogId()))
        .thenReturn(true);
    when(exerciseRepository.readReference(trained.getExercise().getName()))
        .thenReturn(trained.getExercise());
    when(trainedExerciseRepository
        .update(
            new UpdateTrainedExerciseRepoRequestBuilder()
                .setTrainedId(trained.getId())
                .setExercise(trained.getExercise())
                .setSets(List.of(8, 8, 7))
                .build()))
        .thenReturn(trained);

    var result = useCase.update(
        new UpdatedTrainedExerciseCommandBuilder()
            .setTrainedId(trained.getId())
            .setLogId(trained.getLogId())
            .setExerciseId(trained.getExercise().getId())
            .setSets(List.of(8, 8, 7))
            .build());
    assertEquals(trained, result);

  }

  @Test
  void shouldReturnUpdatedTrainedExerciseWithWeight() throws NotFoundException,
      WorkoutLogNotFoundException,
      ExerciseNotFoundException {
    var trained = new TrainedExerciseTestDouble();

    when(workoutLogRepository.exists(trained.getLogId()))
        .thenReturn(true);
    when(exerciseRepository.readReference(trained.getExercise().getName()))
        .thenReturn(trained.getExercise());
    when(trainedExerciseRepository
        .update(
            new UpdateTrainedExerciseRepoRequestBuilder()
                .setTrainedId(trained.getId())
                .setExercise(trained.getExercise())
                .setSets(List.of(8, 8, 7))
                .build()))
        .thenReturn(trained);

    var result = useCase.update(
        new UpdatedTrainedExerciseCommandBuilder()
            .setTrainedId(trained.getId())
            .setLogId(trained.getLogId())
            .setExerciseId(trained.getExercise().getName())
            .setSets(List.of(8, 8, 7))
            .build());
    assertEquals(trained, result);
  }
}