package com.marmouset.workout.app.trainedexercise.usecase.impl;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.ListTrainedExercisesUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.List;
import java.util.UUID;

/**
 * Use case to list trained exercises.
 */
public class ListTrainedExerciseUseCaseImpl
    implements ListTrainedExercisesUseCase {

  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;

  /**
   * Creates a ListTrainedExerciseUseCaseImpl.
   *
   * @param trainedExerciseRepository the trained exercise repo
   * @param workoutLogRepository      the workout repo
   */
  public ListTrainedExerciseUseCaseImpl(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public List<? extends TrainedExercise> list(UUID logId)
      throws WorkoutLogNotFoundException {
    try {
      var workout = workoutLogRepository.readReference(logId);
      return trainedExerciseRepository.read(workout);
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(logId);
    }
  }

}
