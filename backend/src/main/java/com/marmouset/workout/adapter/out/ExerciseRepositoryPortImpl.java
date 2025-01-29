package com.marmouset.workout.adapter.out;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.marmouset.workout.adapter.out.persistence.ExerciseRepository;
import com.marmouset.workout.app.port.out.ExerciseRepositoryPort;
import com.marmouset.workout.domain.exercise.Exercise;

@Repository
public class ExerciseRepositoryPortImpl implements ExerciseRepositoryPort {

  private final ExerciseRepository exerciseRepository;

  public ExerciseRepositoryPortImpl(ExerciseRepository exerciseRepository) {
    this.exerciseRepository = exerciseRepository;

    createExercise(new Exercise("Push up"));
    createExercise(new Exercise("Pull up"));
  }

  @Override
  public Iterable<Exercise> getExercises() {
    return exerciseRepository.findAll();
  }

  @Override
  public Exercise getExerciseReference(UUID id) {
    return exerciseRepository.getReferenceById(id);
  }

  @Override
  public Exercise createExercise(Exercise exercise) {
    return exerciseRepository.save(exercise);
  }

}
