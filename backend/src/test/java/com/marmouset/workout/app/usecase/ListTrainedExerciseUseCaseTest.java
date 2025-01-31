package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.exercise.impl.ExerciseFactoryImpl;
import com.marmouset.workout.app.domain.exercise.impl.TrainedExerciseFactoryImpl;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.impl.WorkoutLogFactoryImpl;
import com.marmouset.workout.app.port.out.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ListTrainedExerciseUseCaseTest {

  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;
  @MockitoBean
  private WorkoutLogRepository workoutLogRepository;
  @MockitoBean
  private TrainedExercisePresenter presenter;
  private ListTrainedExerciseUseCase useCase;
  private TrainedExerciseFactory trainedExerciseFactory;
  private WorkoutLogFactory workoutLogFactory;
  private ExerciseFactory exerciseFactory;


  @BeforeEach
  void setUp() {
    useCase = new ListTrainedExerciseUseCase(trainedExerciseRepository,
        workoutLogRepository, presenter);
    trainedExerciseFactory = new TrainedExerciseFactoryImpl();
    workoutLogFactory = new WorkoutLogFactoryImpl();
    exerciseFactory = new ExerciseFactoryImpl();
  }

  @Test
  void shouldReturnList() throws NotFoundException, WorkoutLogNotFound {
    var workout =
        workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    when(workoutLogRepository.getLogReference(workout.getId())).thenReturn(
        workout);
    var exercise1 = exerciseFactory.create(UUID.randomUUID(), "Push up");
    var exercise2 = exerciseFactory.create(UUID.randomUUID(), "Pull up");
    var trained1 = trainedExerciseFactory.create(exercise1);
    var trained2 = trainedExerciseFactory.create(exercise2);

    when(trainedExerciseRepository.getTrainedExercises(workout))
        .thenReturn(List.of(trained1, trained2));

    var expected1 = new TrainedExerciseResponse(exercise1, new ArrayList<>());
    var expected2 = new TrainedExerciseResponse(exercise2, new ArrayList<>());

    var result = useCase.list(workout.getId()).iterator();
    assertEquals(expected1, result.next());
    assertEquals(expected2, result.next());

  }

  @Test
  void shouldReturnEmpty() throws NotFoundException, WorkoutLogNotFound {
    var workout =
        workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    when(workoutLogRepository.getLogReference(workout.getId()))
        .thenReturn(workout);

    when(trainedExerciseRepository.getTrainedExercises(workout))
        .thenReturn(Collections.emptyList());

    assertTrue(
        StreamSupport.stream(useCase.list(workout.getId()).spliterator(), false)
            .toList().isEmpty());
  }

  @Test
  void shouldThrowWorkoutLogNotFound() throws NotFoundException {
    var id = UUID.randomUUID();
    when(workoutLogRepository.getLogReference(id)).thenThrow(
        new NotFoundException());

    assertThrows(WorkoutLogNotFound.class, () -> useCase.list(id));
  }
}