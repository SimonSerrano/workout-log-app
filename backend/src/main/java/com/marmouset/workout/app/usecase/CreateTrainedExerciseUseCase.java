package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.port.in.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.ExerciseRepository;
import com.marmouset.workout.app.port.out.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;

@Component
public class CreateTrainedExerciseUseCase implements CreateTrainedExercise {
  private final TrainedExerciseRepository trainedExerciseRepositoryPort;
  private final WorkoutLogRepository workoutLogRepositoryPort;
  private final ExerciseRepository exerciseRepositoryPort;
  private final TrainedExerciseFactory factory;
  private final TrainedExercisePresenter presenter;

  public CreateTrainedExerciseUseCase(TrainedExerciseRepository trainedExerciseRepositoryPort,
      WorkoutLogRepository workoutLogRepositoryPort, ExerciseRepository exerciseRepositoryPort,
      TrainedExerciseFactory factory, TrainedExercisePresenter presenter) {
    this.trainedExerciseRepositoryPort = trainedExerciseRepositoryPort;
    this.workoutLogRepositoryPort = workoutLogRepositoryPort;
    this.exerciseRepositoryPort = exerciseRepositoryPort;
    this.factory = factory;
    this.presenter = presenter;
  }

  @Override
  public TrainedExerciseResponse create(CreateTrainedExerciseCommand command) {
    var trained = factory.create(
        workoutLogRepositoryPort.getLogReference(command.getLogId()),
        exerciseRepositoryPort.getExerciseReference(command.getExerciseId()));

    return presenter
        .toResponse(trainedExerciseRepositoryPort
            .createTrainedExercise(new CreateTrainedExerciseRepoRequest()));
  }

}
