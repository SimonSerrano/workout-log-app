package com.marmouset.workout.app.trainedexercise.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exerciseset.ExerciseSetTestDouble;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSetFactory;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.TrainedExerciseTestDouble;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseRepositoryGateway;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExerciseFactory;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainedExerciseRepositoryImplTest {

  private TrainedExerciseRepository repository;
  private TrainedExerciseRepositoryGateway gatewayMock;
  private TrainedExerciseFactory trainedExerciseFactoryMock;
  private ExerciseSetFactory exerciseSetFactoryMock;

  @BeforeEach
  void setUp() {
    gatewayMock = mock(TrainedExerciseRepositoryGateway.class);
    trainedExerciseFactoryMock = mock(TrainedExerciseFactory.class);
    exerciseSetFactoryMock = mock(ExerciseSetFactory.class);

    repository = new TrainedExerciseRepositoryImpl(
        gatewayMock,
        trainedExerciseFactoryMock,
        exerciseSetFactoryMock);
  }

  @Test
  void shouldReturnListOfTrainedExercise() {
    var workout = new WorkoutLogTestDouble();
    var expected = List.of(
        new TrainedExerciseTestDouble(),
        new TrainedExerciseTestDouble());

    doReturn(expected).when(gatewayMock).findByLog(workout);

    assertEquals(expected, repository.read(workout));
  }

  @Test
  void shouldReturnCreatedTrainedExercise() {
    var expected = new TrainedExerciseTestDouble();
    var request = new CreateTrainedExerciseRepoRequest(
        new WorkoutLogTestDouble(),
        new ExerciseTestDouble(),
        Collections.emptyList(),
        10);

    doReturn(expected).when(trainedExerciseFactoryMock).create();
    doReturn(expected).when(gatewayMock).save(expected);

    assertEquals(expected, repository.create(request));
  }

  @Test
  void shouldCallDelete() {
    repository.delete(new DeleteTrainedExerciseRepoRequest(1L));
    verify(gatewayMock, times(1))
        .deleteById(1L);
  }

  @Test
  void shouldReturnUpdatedTrainedExercise() throws NotFoundException {
    var expected = new TrainedExerciseTestDouble()
        .addAllSets(List.of(
            new ExerciseSetTestDouble().setReps(8),
            new ExerciseSetTestDouble().setReps(8)));
    var request = new UpdateTrainedExerciseRepoRequest(
        expected.getId(),
        expected.getExercise(),
        List.of(8, 8),
        10);
    when(exerciseSetFactoryMock.create(8))
        .thenReturn(
            expected.getSets().get(0),
            expected.getSets().get(1));

    doReturn(Optional.of(expected))
        .when(gatewayMock).findById(request.trainedId());
    doReturn(expected).when(gatewayMock).save(expected);

    assertEquals(expected, repository.update(request));
  }

}
