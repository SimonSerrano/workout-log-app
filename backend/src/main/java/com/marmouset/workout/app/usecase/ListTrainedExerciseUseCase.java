package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.port.in.ListTrainedExercises;
import com.marmouset.workout.app.port.out.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;
import com.marmouset.workout.external.database.exception.NotFoundException;
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
  public Iterable<TrainedExerciseResponse> list(UUID logId)
      throws WorkoutLogNotFound {
    try {
      var workout = workoutLogRepository.getLogReference(logId);
      return StreamSupport
          .stream(trainedExerciseRepository.getTrainedExercises(workout)
              .spliterator(), false)
          .map(presenter::toResponse)
          .toList();
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFound(logId);
    }
  }

}
