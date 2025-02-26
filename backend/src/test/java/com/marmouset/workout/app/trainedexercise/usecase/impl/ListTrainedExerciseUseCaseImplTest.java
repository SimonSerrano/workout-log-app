package com.marmouset.workout.app.trainedexercise.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.TrainedExerciseTestDouble;
import com.marmouset.workout.app.trainedexercise.usecase.ListTrainedExercisesUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTrainedExerciseUseCaseImplTest {

  private TrainedExerciseRepository trainedExerciseRepository;
  private WorkoutLogRepository workoutLogRepository;
  private ListTrainedExercisesUseCase useCase;


  @BeforeEach
  void setUp() {
    trainedExerciseRepository = mock(TrainedExerciseRepository.class);
    workoutLogRepository = mock(WorkoutLogRepository.class);
    useCase = new ListTrainedExerciseUseCaseImpl(
        trainedExerciseRepository,
        workoutLogRepository);
  }

  @Test
  void shouldReturnList() throws NotFoundException,
      WorkoutLogNotFoundException {
    var workout = new WorkoutLogTestDouble();
    when(workoutLogRepository.readReference(workout.getId()))
        .thenReturn(workout);
    var trained1 = new TrainedExerciseTestDouble();
    var trained2 = new TrainedExerciseTestDouble();

    doReturn(List.of(trained1, trained2))
        .when(trainedExerciseRepository).read(workout);

    var result = useCase.list(workout.getId()).iterator();
    assertEquals(trained1, result.next());
    assertEquals(trained2, result.next());

  }

  @Test
  void shouldReturnEmpty() throws NotFoundException,
      WorkoutLogNotFoundException {
    var workout = new WorkoutLogTestDouble();
    when(workoutLogRepository.readReference(workout.getId()))
        .thenReturn(workout);

    when(trainedExerciseRepository.read(workout))
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