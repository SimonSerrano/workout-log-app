package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.ExerciseNotFound;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.exercise.impl.ExerciseFactoryImpl;
import com.marmouset.workout.app.domain.exercise.impl.TrainedExerciseFactoryImpl;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import java.util.Collections;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
  private TrainedExerciseFactory trainedExerciseFactory;
  @MockitoBean
  private TrainedExercisePresenter presenter;

  private ExerciseFactory exerciseFactory;

  private CreateTrainedExerciseUseCase useCase;

  @BeforeEach
  void setUp() {
    exerciseFactory = new ExerciseFactoryImpl();
    trainedExerciseFactory = new TrainedExerciseFactoryImpl();
    useCase = new CreateTrainedExerciseUseCase(
        trainedExerciseRepository,
        workoutLogRepository,
        exerciseRepository,
        trainedExerciseFactory,
        presenter);
  }

  @Test
  void shouldReturnCreatedTrainedExercise() throws ExerciseNotFound {
    var exercise = exerciseFactory.create(UUID.randomUUID(), "Pull ups");
    var expected =
        new TrainedExerciseResponse(exercise, Collections.emptyList());

    assertEquals(expected, useCase.create(
        new CreateTrainedExerciseCommand(UUID.randomUUID(), exercise.id())));
  }
}