package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Component;

@Component
class ListTrainedExerciseUseCase implements ListTrainedExercises {

  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;
  private final TrainedExercisePresenter presenter;

  ListTrainedExerciseUseCase(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository,
      TrainedExercisePresenter presenter) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
    this.presenter = presenter;
  }

  @Override
  public List<TrainedExerciseResponse> list(UUID logId)
      throws WorkoutLogNotFoundException {
    try {
      var workout = workoutLogRepository.getLogReference(logId);
      return StreamSupport
          .stream(trainedExerciseRepository.getTrainedExercises(workout)
              .spliterator(), false)
          .map(presenter::present)
          .toList();
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(logId);
    }
  }

}
