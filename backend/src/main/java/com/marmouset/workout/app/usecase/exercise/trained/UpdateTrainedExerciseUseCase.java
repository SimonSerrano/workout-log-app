package com.marmouset.workout.app.usecase.exercise.trained;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.UpdateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.UpdateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
class UpdateTrainedExerciseUseCase implements UpdateTrainedExercise {

  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;
  private final ExerciseRepository exerciseRepository;

  private final TrainedExercisePresenter presenter;

  public UpdateTrainedExerciseUseCase(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository,
      ExerciseRepository exerciseRepository,
      TrainedExercisePresenter presenter) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.presenter = presenter;
    this.workoutLogRepository = workoutLogRepository;
    this.exerciseRepository = exerciseRepository;
  }

  @Override
  public TrainedExerciseResponse update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException {

    if (!workoutLogRepository.exists(command.logId())) {
      throw new WorkoutLogNotFoundException(command.logId());
    }

    try {
      var exercise = exerciseRepository.readReference(command.exerciseId());
      var requestBuilder = new UpdateTrainedExerciseRepoRequestBuilder()
          .setTrainedId(command.trainedId())
          .setExerciseContainer(exercise)
          .setSets(command.sets())
          .setWeight(command.weight());
      return presenter
          .present(trainedExerciseRepository.update(requestBuilder.build()));
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }

  }
}
