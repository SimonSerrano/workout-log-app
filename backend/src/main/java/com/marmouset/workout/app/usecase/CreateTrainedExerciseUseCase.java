package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.in.CreateTrainedExercisePort;
import com.marmouset.workout.app.port.out.ExerciseRepositoryPort;
import com.marmouset.workout.app.port.out.TrainedExerciseRepositoryPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

@Component
public class CreateTrainedExerciseUseCase implements CreateTrainedExercisePort {
  private final TrainedExerciseRepositoryPort trainedExerciseRepositoryPort;
  private final WorkoutLogRepositoryPort workoutLogRepositoryPort;
  private final ExerciseRepositoryPort exerciseRepositoryPort;

  public CreateTrainedExerciseUseCase(TrainedExerciseRepositoryPort trainedExerciseRepositoryPort,
      WorkoutLogRepositoryPort workoutLogRepositoryPort, ExerciseRepositoryPort exerciseRepositoryPort) {
    this.trainedExerciseRepositoryPort = trainedExerciseRepositoryPort;
    this.workoutLogRepositoryPort = workoutLogRepositoryPort;
    this.exerciseRepositoryPort = exerciseRepositoryPort;
  }

  @Override
  public TrainedExercise create(CreateTrainedExerciseCommand command) {
    var trained = new TrainedExercise();
    var exercise = exerciseRepositoryPort.getExerciseReference(command.getExerciseId());
    var workout = workoutLogRepositoryPort.getLogReference(command.getLogId());

    trained.setExercise(exercise);
    trained.setLog(workout);

    return trainedExerciseRepositoryPort.createTrainedExercise(trained);
  }

}
