package com.marmouset.workout.app.usecase.exercise.trained;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
class CreateTrainedExerciseUseCase implements CreateTrainedExercise {
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;
  private final ExerciseRepository exerciseRepository;
  private final TrainedExercisePresenter presenter;

  CreateTrainedExerciseUseCase(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository,
      ExerciseRepository exerciseRepository,
      TrainedExercisePresenter presenter) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
    this.exerciseRepository = exerciseRepository;
    this.presenter = presenter;
  }

  @Override
  public TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFoundException, WorkoutLogNotFoundException {

    WorkoutLogEntityContainer workout;
    try {
      workout = workoutLogRepository.readReference(command.logId());
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(command.logId());
    }

    try {
      var exercise =
          exerciseRepository.readReference(command.exerciseId());

      var response = trainedExerciseRepository.create(
          new CreateTrainedExerciseRepoRequestBuilder()
              .setLogContainer(workout)
              .setExerciseContainer(exercise)
              .setSets(command.sets())
              .setWeight(command.weight())
              .build());

      return presenter.present(response);
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }


  }

}
