package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListTrainedExercisesPort;
import com.marmouset.workout.app.port.out.TrainedExerciseRepositoryPort;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

@Component
public class ListTrainedExerciseUseCase implements ListTrainedExercisesPort {

  private final TrainedExerciseRepositoryPort trainedExerciseRepositoryPort;

  public ListTrainedExerciseUseCase(TrainedExerciseRepositoryPort trainedExerciseRepositoryPort) {
    this.trainedExerciseRepositoryPort = trainedExerciseRepositoryPort;
  }

  @Override
  public Iterable<TrainedExercise> listTrainedExercises(UUID logId) {
    return trainedExerciseRepositoryPort.getTrainedExercises(logId);
  }

}
