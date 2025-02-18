package com.marmouset.workout.app.usecase.exercise.trained;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
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
class ListTrainedExerciseUseCaseTest {

  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;
  @MockitoBean
  private WorkoutLogRepository workoutLogRepository;
  @Autowired
  private TrainedExercisePresenter trainedExercisePresenter;
  @Autowired
  private ExercisePresenter exercisePresenter;
  private ListTrainedExerciseUseCase useCase;
  @Autowired
  private TrainedExerciseFactory trainedExerciseFactory;
  @Autowired
  private WorkoutLogFactory workoutLogFactory;
  @Autowired
  private ExerciseFactory exerciseFactory;


  @BeforeEach
  void setUp() {
    useCase = new ListTrainedExerciseUseCase(trainedExerciseRepository,
        workoutLogRepository, trainedExercisePresenter);
  }

  @Test
  void shouldReturnList() throws NotFoundException,
      WorkoutLogNotFoundException {
    var workout =
        workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    WorkoutLogEntityContainer workoutLogEntityContainer =
        () -> (WorkoutLogEntity) workout::getId;
    when(workoutLogRepository.readReference(workout.getId())).thenReturn(
        workoutLogEntityContainer);
    var exercise1 = exerciseFactory.create("Push up");
    var exercise2 = exerciseFactory.create("Pull up");
    var trained1 =
        trainedExerciseFactory.create(
            new Random().nextLong(), workout.getId(), exercise1);
    var trained2 =
        trainedExerciseFactory.create(
            new Random().nextLong(), workout.getId(), exercise2);

    when(trainedExerciseRepository.read(workoutLogEntityContainer))
        .thenReturn(List.of(trained1, trained2));

    var expected1 = new TrainedExerciseResponse(
        trained1.getId(),
        trained1.getLogId(),
        exercisePresenter.present(exercise1),
        Collections.emptyList());
    var expected2 = new TrainedExerciseResponse(
        trained2.getId(),
        trained2.getLogId(),
        exercisePresenter.present(exercise2),
        Collections.emptyList());

    var result = useCase.list(workout.getId()).iterator();
    assertEquals(expected1, result.next());
    assertEquals(expected2, result.next());

  }

  @Test
  void shouldReturnEmpty() throws NotFoundException,
      WorkoutLogNotFoundException {
    var workout =
        workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    WorkoutLogEntityContainer workoutLogEntityContainer =
        () -> (WorkoutLogEntity) workout::getId;
    when(workoutLogRepository.readReference(workout.getId()))
        .thenReturn(workoutLogEntityContainer);

    when(trainedExerciseRepository.read(workoutLogEntityContainer))
        .thenReturn(Collections.emptyList());

    assertTrue(useCase.list(workout.getId()).isEmpty());
  }

  @Test
  void shouldThrowWorkoutLogNotFound() throws NotFoundException {
    var id = UUID.randomUUID();
    when(workoutLogRepository.readReference(id)).thenThrow(
        new NotFoundException());

    assertThrows(WorkoutLogNotFoundException.class, () -> useCase.list(id));
  }
}