package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListExercisesPort;
import com.marmouset.workout.app.port.out.ExerciseRepositoryPort;
import com.marmouset.workout.domain.exercise.Exercise;

@Component
public class ListExercisesUseCase implements ListExercisesPort {

  private final ExerciseRepositoryPort exerciseRepositoryPort;

  public ListExercisesUseCase(ExerciseRepositoryPort exerciseRepositoryPort) {
    this.exerciseRepositoryPort = exerciseRepositoryPort;
  }

  @Override
  public Iterable<Exercise> listExercises() {
    return exerciseRepositoryPort.getExercises();
  }

}
