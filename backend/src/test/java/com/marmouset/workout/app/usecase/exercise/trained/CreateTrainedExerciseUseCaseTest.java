package com.marmouset.workout.app.usecase.exercise.trained;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponseBuilder;
import com.marmouset.workout.app.port.out.set.ExerciseSetPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntity;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class CreateTrainedExerciseUseCaseTest {

  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;
  @MockitoBean
  private WorkoutLogRepository workoutLogRepository;
  @MockitoBean
  private ExerciseRepository exerciseRepository;
  @Autowired
  private TrainedExercisePresenter trainedExercisePresenter;
  @Autowired
  private ExercisePresenter exercisePresenter;
  @Autowired
  private ExerciseSetPresenter exerciseSetPresenter;

  @Autowired
  private ExerciseFactory exerciseFactory;
  @Autowired
  private TrainedExerciseFactory trainedExerciseFactory;
  @Autowired
  private WorkoutLogFactory workoutLogFactory;

  private CreateTrainedExerciseUseCase useCase;


  @BeforeEach
  void setUp() {
    useCase = new CreateTrainedExerciseUseCase(
        trainedExerciseRepository,
        workoutLogRepository,
        exerciseRepository,
        trainedExercisePresenter);
  }

  @Test
  void shouldReturnCreatedTrainedExercise()
      throws ExerciseNotFoundException, NotFoundException,
      WorkoutLogNotFoundException {
    var workout =
        workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    var trainedExercise =
        trainedExerciseFactory.create(new Random().nextLong(), workout.getId(),
            exerciseFactory.create("Pull ups"));

    WorkoutLogEntityContainer containedWorkout =
        () -> (WorkoutLogEntity) workout::getId;
    ExerciseEntityContainer exerciseEntityContainer =
        createExerciseEntityContainer(trainedExercise);

    prepareRepositoryMocksHappyReturns(
        trainedExercise,
        exerciseEntityContainer,
        workout,
        containedWorkout,
        new CreateTrainedExerciseRepoRequestBuilder()
            .setLogContainer(containedWorkout)
            .setExerciseContainer(exerciseEntityContainer)
            .setSets(List.of(6, 6, 6)));

    var expected =
        new TrainedExerciseResponseBuilder()
            .setId(trainedExercise.getId())
            .setLogId(trainedExercise.getLogId())
            .setExercise(
                exercisePresenter.present(trainedExercise.getExercise()))
            .setSets(Collections.emptyList())
            .build();

    assertEquals(expected, useCase.create(
        new CreateTrainedExerciseCommandBuilder()
            .setLogId(workout.getId())
            .setExerciseId(trainedExercise.getExercise().name())
            .setSets(List.of(6, 6, 6))
            .build()));
  }


  @Test
  void shouldReturnCreatedTrainedExerciseWithWeight()
      throws NotFoundException, WorkoutLogNotFoundException,
      ExerciseNotFoundException {
    var weight = 30;
    var workout =
        workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    var trainedExercise = trainedExerciseFactory.create(
        new Random().nextLong(),
        workout.getId(),
        exerciseFactory.create("Pull ups"));
    trainedExercise.setWeight(weight);

    WorkoutLogEntityContainer containedWorkout =
        () -> (WorkoutLogEntity) workout::getId;
    ExerciseEntityContainer
        exerciseEntityContainer =
        createExerciseEntityContainer(trainedExercise);

    prepareRepositoryMocksHappyReturns(
        trainedExercise,
        exerciseEntityContainer,
        workout,
        containedWorkout,
        new CreateTrainedExerciseRepoRequestBuilder()
            .setLogContainer(containedWorkout)
            .setExerciseContainer(exerciseEntityContainer)
            .setSets(List.of(6, 6, 6))
            .setWeight(weight));

    var expected =
        new TrainedExerciseResponseBuilder()
            .setId(trainedExercise.getId())
            .setLogId(trainedExercise.getLogId())
            .setExercise(
                exercisePresenter.present(trainedExercise.getExercise()))
            .setSets(Collections.emptyList())
            .setWeight(weight)
            .build();

    assertEquals(expected, useCase.create(
        new CreateTrainedExerciseCommandBuilder()
            .setLogId(workout.getId())
            .setExerciseId(trainedExercise.getExercise().name())
            .setSets(List.of(6, 6, 6))
            .setWeight(weight)
            .build()));
  }

  private void prepareRepositoryMocksHappyReturns(
      TrainedExercise trainedExercise,
      ExerciseEntityContainer exerciseEntityContainer,
      WorkoutLog workout,
      WorkoutLogEntityContainer containedWorkout,
      CreateTrainedExerciseRepoRequestBuilder containedWorkout1)
      throws NotFoundException {
    when(
        exerciseRepository.readReference(trainedExercise.getExercise().name()))
        .thenReturn(exerciseEntityContainer);
    when(workoutLogRepository.readReference(workout.getId()))
        .thenReturn(containedWorkout);
    when(trainedExerciseRepository
        .create(
            containedWorkout1
                .build()))
        .thenReturn(trainedExercise);
  }

  private ExerciseEntityContainer createExerciseEntityContainer(
      TrainedExercise trainedExercise) {
    return
        () -> new ExerciseEntity() {
          @Override
          public String getName() {
            return trainedExercise.getExercise().name();
          }

          @Override
          public String getId() {
            return trainedExercise.getExercise().name();
          }
        };
  }
}
