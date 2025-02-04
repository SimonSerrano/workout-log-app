package com.marmouset.workout.app.usecase.exercise.trained;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.UpdateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.UpdateTrainedExerciseRepoRequest;
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
    WorkoutLog workout;
    try {
      workout = workoutLogRepository.readReference(command.logId());
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(command.logId());
    }

    try {
      var exercise = exerciseRepository.readReference(command.exerciseId());
      return presenter.present(
          trainedExerciseRepository.update(new UpdateTrainedExerciseRepoRequest(
              command.trainedId(),
              workout,
              exercise))
      );
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }

  }
}
