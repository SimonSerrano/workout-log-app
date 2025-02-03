package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.time.Instant;
import java.util.Collections;
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
    var trainedExercise = trainedExerciseFactory.create(UUID.randomUUID(),
        exerciseFactory.create(UUID.randomUUID(), "Pull ups"));

    when(exerciseRepository.readReference(trainedExercise.getExercise().id()))
        .thenReturn(trainedExercise.getExercise());
    when(workoutLogRepository.readReference(workout.getId()))
        .thenReturn(workout);
    when(trainedExerciseRepository
        .create(
            new CreateTrainedExerciseRepoRequest(workout,
                trainedExercise.getExercise())))
        .thenReturn(trainedExercise);

    var expected = new TrainedExerciseResponse(
        trainedExercise.getId(),
        exercisePresenter.present(trainedExercise.getExercise()),
        Collections.emptyList());

    assertEquals(expected, useCase.create(
        new CreateTrainedExerciseCommand(workout.getId(),
            trainedExercise.getExercise().id())));
  }
}