package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListTrainedExercisesPort;
import com.marmouset.workout.app.port.out.TrainedExerciseRepositoryPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

@Component
public class ListTrainedExerciseUseCase implements ListTrainedExercisesPort {

  private final TrainedExerciseRepositoryPort trainedExerciseRepositoryPort;
  private final WorkoutLogRepositoryPort workoutLogRepositoryPort;

  public ListTrainedExerciseUseCase(TrainedExerciseRepositoryPort trainedExerciseRepositoryPort,
      WorkoutLogRepositoryPort workoutLogRepositoryPort) {
    this.trainedExerciseRepositoryPort = trainedExerciseRepositoryPort;
    this.workoutLogRepositoryPort = workoutLogRepositoryPort;
  }

  @Override
  public Iterable<TrainedExercise> listTrainedExercises(UUID logId) {
    var workout = workoutLogRepositoryPort.getLogReference(logId);
    return trainedExerciseRepositoryPort.getTrainedExercises(workout);
  }

}
