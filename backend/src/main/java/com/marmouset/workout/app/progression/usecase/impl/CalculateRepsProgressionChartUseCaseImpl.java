package com.marmouset.workout.app.progression.usecase.impl;

import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.entity.RepsDataPoint;
import com.marmouset.workout.app.progression.entity.RepsProgressionChart;
import com.marmouset.workout.app.progression.entity.impl.RepsDataPointImpl;
import com.marmouset.workout.app.progression.entity.impl.RepsProgressionChartImpl;
import com.marmouset.workout.app.progression.usecase.CalculateRepsProgressionChartUseCase;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.GetTrainedExerciseByExerciseIdRepoRequest;
import java.util.List;

/**
 * Implementation to calculate the reps progression chart.
 */
public class CalculateRepsProgressionChartUseCaseImpl
    implements CalculateRepsProgressionChartUseCase {

  private final ExerciseRepository exerciseRepository;
  private final TrainedExerciseRepository trainedExerciseRepository;

  /**
   * Creates a CalculateRepsProgressionChartUseCaseImpl.
   *
   * @param exerciseRepository        the exercise repo
   * @param trainedExerciseRepository the trained exercise repo
   */
  public CalculateRepsProgressionChartUseCaseImpl(
      ExerciseRepository exerciseRepository,
      TrainedExerciseRepository trainedExerciseRepository) {
    this.exerciseRepository = exerciseRepository;
    this.trainedExerciseRepository = trainedExerciseRepository;
  }

  @Override
  public RepsProgressionChart calculate(
      CalculateRepsProgressionChartCommand command)
      throws ExerciseNotFoundException {
    try {
      var exercise = exerciseRepository.read(command.exerciseId());
      var trainedList = trainedExerciseRepository
          .getTrainedExerciseByExerciseId(
              new GetTrainedExerciseByExerciseIdRepoRequest(exercise));
      List<? extends RepsDataPoint> chart = trainedList.stream()
          .map(trained -> new RepsDataPointImpl(
              trained.getWorkoutDate(),
              trained.getSets().stream().mapToInt(set -> set.getReps()).sum()))
          .toList();

      return new RepsProgressionChartImpl(exercise, chart);
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }
  }

}
