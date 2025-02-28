package com.marmouset.workout.app.progression.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.RepsProgressionChartTestDouble;
import com.marmouset.workout.app.progression.adapter.ProgressionController;
import com.marmouset.workout.app.progression.adapter.dto.RepsDataPointResponseImpl;
import com.marmouset.workout.app.progression.adapter.dto.RepsProgressionChartResponseImpl;
import com.marmouset.workout.app.progression.usecase.CalculateRepsProgressionChartUseCase;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgressionControllerImplTest {

  private ProgressionController controller;
  private CalculateRepsProgressionChartUseCase repsProgUsecase;

  @BeforeEach
  void setUp() {
    repsProgUsecase = mock(CalculateRepsProgressionChartUseCase.class);
    controller = new ProgressionControllerImpl(repsProgUsecase);
  }

  @Test
  void shouldReturnTheProgressionChartAsResponse()
      throws ExerciseNotFoundException {
    var progressionChart = new RepsProgressionChartTestDouble();
    var expected = new RepsProgressionChartResponseImpl(
        new ExerciseResponse(progressionChart.getExercise().getName()),
        List.of(
            new RepsDataPointResponseImpl(
                progressionChart.getChart().get(0).date().getEpochSecond(),
                progressionChart.getChart().get(0).reps()),
            new RepsDataPointResponseImpl(
                progressionChart.getChart().get(1).date().getEpochSecond(),
                progressionChart.getChart().get(1).reps()),
            new RepsDataPointResponseImpl(
                progressionChart.getChart().get(2).date().getEpochSecond(),
                progressionChart.getChart().get(2).reps())));

    var command = new CalculateRepsProgressionChartCommand(
        expected.exercise().name());

    doReturn(progressionChart).when(repsProgUsecase).calculate(command);

    assertEquals(expected, controller.calculateRepsProgressionChart(command));
  }

}
