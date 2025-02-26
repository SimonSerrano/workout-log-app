package com.marmouset.workout.app.trainedexercise.usecase.impl;

import com.marmouset.workout.app.trainedexercise.usecase.DeleteTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.UUID;


/**
 * Use case to delete a trained exercise.
 */
public class DeleteTrainedExerciseUseCaseImpl
    implements DeleteTrainedExerciseUseCase {
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;


  /**
   * Creates a DeleteTrainedExerciseUseCaseImpl.
   *
   * @param trainedExerciseRepository the trained exercise repo
   * @param workoutLogRepository      the workout repo
   */
  public DeleteTrainedExerciseUseCaseImpl(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public void delete(UUID logId, Long trainedId)
      throws WorkoutLogNotFoundException {
    if (!workoutLogRepository.exists(logId)) {
      throw new WorkoutLogNotFoundException(logId);
    }
    trainedExerciseRepository.delete(
        new DeleteTrainedExerciseRepoRequest(trainedId));
  }
}
