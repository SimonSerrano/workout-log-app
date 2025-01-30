package com.marmouset.workout.app.usecase;

import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListTrainedExercises;
import com.marmouset.workout.app.port.out.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;

@Component
public class ListTrainedExerciseUseCase implements ListTrainedExercises {

  private final TrainedExerciseRepository trainedExerciseRepositoryPort;
  private final WorkoutLogRepository workoutLogRepositoryPort;
  private final TrainedExercisePresenter presenter;

  public ListTrainedExerciseUseCase(TrainedExerciseRepository trainedExerciseRepositoryPort,
      WorkoutLogRepository workoutLogRepositoryPort, TrainedExercisePresenter presenter) {
    this.trainedExerciseRepositoryPort = trainedExerciseRepositoryPort;
    this.workoutLogRepositoryPort = workoutLogRepositoryPort;
    this.presenter = presenter;
  }

  @Override
  public Iterable<TrainedExerciseResponse> list(UUID logId) {
    var workout = workoutLogRepositoryPort.getLogReference(logId);
    return StreamSupport
        .stream(trainedExerciseRepositoryPort.getTrainedExercises(workout).spliterator(), false)
        .map(presenter::toResponse).toList();
  }

}
