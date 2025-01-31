package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.ExerciseNotFound;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.exercise.impl.ExerciseFactoryImpl;
import com.marmouset.workout.app.domain.exercise.impl.TrainedExerciseFactoryImpl;
import com.marmouset.workout.app.port.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.ExerciseRepository;
import com.marmouset.workout.app.port.out.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;
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