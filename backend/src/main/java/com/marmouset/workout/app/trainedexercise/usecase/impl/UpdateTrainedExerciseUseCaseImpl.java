package com.marmouset.workout.app.trainedexercise.usecase.impl;

import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.UpdateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;

/**
 * Use case to update a trained exercise.
 */
public class UpdateTrainedExerciseUseCaseImpl
    implements UpdateTrainedExerciseUseCase {

  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;
  private final ExerciseRepository exerciseRepository;

  /**
   * Creates a UpdateTrainedExerciseUseCaseImpl.
   *
   * @param trainedExerciseRepository the trained exercise repo
   * @param workoutLogRepository      the workout repo
   * @param exerciseRepository        the exercise repo
   */
  public UpdateTrainedExerciseUseCaseImpl(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository,
      ExerciseRepository exerciseRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
    this.exerciseRepository = exerciseRepository;
  }

  @Override
  public TrainedExercise update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException {

    if (!workoutLogRepository.exists(command.logId())) {
      throw new WorkoutLogNotFoundException(command.logId());
    }

    try {
      var exercise =
          exerciseRepository.readReference(command.exerciseId());
      var requestBuilder = new UpdateTrainedExerciseRepoRequestBuilder()
          .setTrainedId(command.trainedId())
          .setExercise(exercise)
          .setSets(command.sets())
          .setWeight(command.weight());
      return trainedExerciseRepository.update(requestBuilder.build());
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }

  }
}
