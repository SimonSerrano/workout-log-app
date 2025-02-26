package com.marmouset.workout.app.trainedexercise.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.TrainedExerciseTestDouble;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.CreateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateTrainedExerciseUseCaseImplTest {

  private TrainedExerciseRepository trainedExerciseRepository;
  private WorkoutLogRepository workoutLogRepository;
  private ExerciseRepository exerciseRepository;

  private CreateTrainedExerciseUseCase useCase;


  @BeforeEach
  void setUp() {
    trainedExerciseRepository = mock(TrainedExerciseRepository.class);
    workoutLogRepository = mock(WorkoutLogRepository.class);
    exerciseRepository = mock(ExerciseRepository.class);
    useCase = new CreateTrainedExerciseUseCaseImpl(
        trainedExerciseRepository,
        workoutLogRepository,
        exerciseRepository
    );
  }

  @Test
  void shouldReturnCreatedTrainedExercise()
      throws ExerciseNotFoundException, NotFoundException,
      WorkoutLogNotFoundException {
    var expected = new TrainedExerciseTestDouble();
    var log = new WorkoutLogTestDouble();
    var exercise = new ExerciseTestDouble();

    prepareRepositoryMocksHappyReturns(
        expected,
        exercise,
        log,
        new CreateTrainedExerciseRepoRequestBuilder()
            .setLog(log)
            .setExercise(exercise)
            .setSets(List.of(6, 6, 6)));

    assertEquals(expected, useCase.create(
        new CreateTrainedExerciseCommandBuilder()
            .setLogId(log.getId())
            .setExerciseId(exercise.getName())
            .setSets(List.of(6, 6, 6))
            .build()));
  }


  @Test
  void shouldReturnCreatedTrainedExerciseWithWeight()
      throws NotFoundException, WorkoutLogNotFoundException,
      ExerciseNotFoundException {
    var weight = 30;
    var workout = new WorkoutLogTestDouble();
    var trainedExercise = new TrainedExerciseTestDouble();
    var exercise = new ExerciseTestDouble();
    trainedExercise.setWeight(weight);

    prepareRepositoryMocksHappyReturns(
        trainedExercise,
        exercise,
        workout,
        new CreateTrainedExerciseRepoRequestBuilder()
            .setLog(workout)
            .setExercise(exercise)
            .setSets(List.of(6, 6, 6))
            .setWeight(weight));


    assertEquals(trainedExercise, useCase.create(
        new CreateTrainedExerciseCommandBuilder()
            .setLogId(workout.getId())
            .setExerciseId(trainedExercise.getExercise().getName())
            .setSets(List.of(6, 6, 6))
            .setWeight(weight)
            .build()));
  }


  @Test
  void shouldThrowWorkoutLogNotFound() throws NotFoundException {
    var uuid = UUID.randomUUID();
    when(workoutLogRepository.readReference(uuid))
        .thenThrow(NotFoundException.class);

    assertThrows(WorkoutLogNotFoundException.class, () -> useCase.create(
        new CreateTrainedExerciseCommandBuilder().setLogId(uuid)
            .setExerciseId("Pull ups").build()));
  }

  @Test
  void shouldThrowExerciseNotFound() throws NotFoundException {
    var uuid = UUID.randomUUID();
    when(workoutLogRepository.readReference(uuid))
        .thenReturn(new WorkoutLogTestDouble());
    when(exerciseRepository.readReference("Pull ups"))
        .thenThrow(NotFoundException.class);

    assertThrows(ExerciseNotFoundException.class, () -> useCase.create(
        new CreateTrainedExerciseCommandBuilder().setLogId(uuid)
            .setExerciseId("Pull ups").build()));
  }

  private void prepareRepositoryMocksHappyReturns(
      TrainedExercise trainedExercise,
      Exercise exercise,
      WorkoutLog workout,
      CreateTrainedExerciseRepoRequestBuilder requestBuilder)
      throws NotFoundException {
    when(
        exerciseRepository.readReference(exercise.getName()))
        .thenReturn(exercise);
    when(workoutLogRepository.readReference(workout.getId()))
        .thenReturn(workout);
    when(trainedExerciseRepository
        .create(requestBuilder.build()))
        .thenReturn(trainedExercise);
  }

}
