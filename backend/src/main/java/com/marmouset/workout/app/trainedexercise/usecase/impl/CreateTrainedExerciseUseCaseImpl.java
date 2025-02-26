package com.marmouset.workout.app.trainedexercise.usecase.impl;

import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.CreateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;

/**
 * Use case to create a trained exercise.
 */
public class CreateTrainedExerciseUseCaseImpl
    implements CreateTrainedExerciseUseCase {
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;
  private final ExerciseRepository exerciseRepository;

  /**
   * Creates a CreateTrainedExerciseUseCaseImpl.
   *
   * @param trainedExerciseRepository the trained exercise repo
   * @param workoutLogRepository      the workout repo
   * @param exerciseRepository        the exercise repo
   */
  public CreateTrainedExerciseUseCaseImpl(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository,
      ExerciseRepository exerciseRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
    this.exerciseRepository = exerciseRepository;
  }

  @Override
  public TrainedExercise create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFoundException, WorkoutLogNotFoundException {

    WorkoutLog workout;
    try {
      workout = workoutLogRepository.readReference(command.logId());
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(command.logId());
    }

    try {
      var exercise =
          exerciseRepository.readReference(command.exerciseId());

      return trainedExerciseRepository.create(
          new CreateTrainedExerciseRepoRequestBuilder()
              .setLog(workout)
              .setExercise(exercise)
              .setSets(command.sets())
              .setWeight(command.weight())
              .build());
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }


  }

}
