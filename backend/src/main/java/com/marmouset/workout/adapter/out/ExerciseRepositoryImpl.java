package com.marmouset.workout.adapter.out;

import org.springframework.context.annotation.Lazy;

import com.marmouset.workout.adapter.out.persistence.ExerciseRepository;
import com.marmouset.workout.app.port.out.ExerciseRepositoryPort;
import com.marmouset.workout.domain.exercise.Exercise;

public class ExerciseRepositoryImpl implements ExerciseRepositoryPort {

  private final ExerciseRepository exerciseRepository;

  public ExerciseRepositoryImpl(@Lazy ExerciseRepository exerciseRepository) {
    this.exerciseRepository = exerciseRepository;

    this.exerciseRepository.save(new Exercise("Push up"));
    this.exerciseRepository.save(new Exercise("Pull up"));
  }

  @Override
  public Iterable<Exercise> getExercises() {
    return exerciseRepository.findAll();
  }

}
