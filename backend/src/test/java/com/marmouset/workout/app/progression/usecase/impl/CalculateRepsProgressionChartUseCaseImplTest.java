package com.marmouset.workout.app.progression.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.exerciseset.ExerciseSetTestDouble;
import com.marmouset.workout.app.progression.entity.impl.RepsDataPointImpl;
import com.marmouset.workout.app.progression.entity.impl.RepsProgressionChartImpl;
import com.marmouset.workout.app.progression.usecase.CalculateRepsProgressionChartUseCase;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.TrainedExerciseTestDouble;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.GetTrainedExerciseByExerciseIdRepoRequest;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateRepsProgressionChartUseCaseImplTest {

  private CalculateRepsProgressionChartUseCase usecase;
  private ExerciseRepository exerciseRepositoryMock;
  private TrainedExerciseRepository trainedExerciseRepositoryMock;

  @BeforeEach
  void setUp() {
    exerciseRepositoryMock = mock(ExerciseRepository.class);
    trainedExerciseRepositoryMock = mock(TrainedExerciseRepository.class);
    usecase = new CalculateRepsProgressionChartUseCaseImpl(
        exerciseRepositoryMock,
        trainedExerciseRepositoryMock);
  }

  @Test
  void shouldReturnRepsProgressionChart() throws ExerciseNotFoundException,
      NotFoundException {
    var expected = new RepsProgressionChartImpl(
        new ExerciseTestDouble(),
        List.of(
            new RepsDataPointImpl(
                new GregorianCalendar(
                    2025,
                    1,
                    27).toInstant(),
                30),
            new RepsDataPointImpl(
                new GregorianCalendar(
                    2025,
                    2,
                    1).toInstant(),
                39),
            new RepsDataPointImpl(
                new GregorianCalendar(
                    2025,
                    2,
                    4).toInstant(),
                45)));

    var trainedList = List.of(
        new TrainedExerciseTestDouble()
            .setLog(new WorkoutLogTestDouble()
                .setCreatedAt(expected.getChart().get(0).date()))
            .addAllSets(List.of(
                new ExerciseSetTestDouble().setReps(15),
                new ExerciseSetTestDouble().setReps(15))),
        new TrainedExerciseTestDouble()
            .setLog(new WorkoutLogTestDouble()
                .setCreatedAt(expected.getChart().get(1).date()))
            .addAllSets(List.of(
                new ExerciseSetTestDouble().setReps(13),
                new ExerciseSetTestDouble().setReps(13),
                new ExerciseSetTestDouble().setReps(13))),
        new TrainedExerciseTestDouble()
            .setLog(new WorkoutLogTestDouble()
                .setCreatedAt(expected.getChart().get(2).date()))
            .addAllSets(List.of(
                new ExerciseSetTestDouble().setReps(15),
                new ExerciseSetTestDouble().setReps(15),
                new ExerciseSetTestDouble().setReps(15))));

    doReturn(expected.getExercise())
        .when(exerciseRepositoryMock).read(expected.getExercise().getId());
    doReturn(trainedList)
        .when(trainedExerciseRepositoryMock).getTrainedExerciseByExerciseId(
            new GetTrainedExerciseByExerciseIdRepoRequest(
                expected.getExercise()));

    var command = new CalculateRepsProgressionChartCommand(
        expected.getExercise().getName());

    assertEquals(expected, usecase.calculate(command));
  }

  @Test
  void shouldThrowExerciseNotFound() throws NotFoundException {
    var exercise = new ExerciseTestDouble();
    doThrow(NotFoundException.class)
        .when(exerciseRepositoryMock).read(exercise.getId());

    var command = new CalculateRepsProgressionChartCommand(
        exercise.getName());

    assertThrows(
        ExerciseNotFoundException.class,
        () -> usecase.calculate(command));
  }

}
