package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFound;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.port.in.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.ExerciseRepository;
import com.marmouset.workout.app.port.out.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;
import com.marmouset.workout.external.database.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
class CreateTrainedExerciseUseCase implements CreateTrainedExercise {
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;
  private final ExerciseRepository exerciseRepository;
  private final TrainedExerciseFactory factory;
  private final TrainedExercisePresenter presenter;

  CreateTrainedExerciseUseCase(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository,
      ExerciseRepository exerciseRepository,
      TrainedExerciseFactory factory, TrainedExercisePresenter presenter) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
    this.exerciseRepository = exerciseRepository;
    this.factory = factory;
    this.presenter = presenter;
  }

  @Override
  public TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFound {
    try {
      var trained = factory.create(
          exerciseRepository.getExerciseReference(command.getExerciseId()));
      return presenter
          .toResponse(trainedExerciseRepository
              .createTrainedExercise(new CreateTrainedExerciseRepoRequest()));
    } catch (NotFoundException e) {
      throw new ExerciseNotFound(command.getExerciseId());
    }


  }

}
