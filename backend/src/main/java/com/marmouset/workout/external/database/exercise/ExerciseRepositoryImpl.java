package com.marmouset.workout.external.database.exercise;

import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.ExerciseRepository;
import com.marmouset.workout.app.port.out.dto.CreateExerciseRepoRequest;

@Repository
public class ExerciseRepositoryImpl implements ExerciseRepository {

  private final JpaExerciseRepository exerciseRepository;
  private final ExerciseMapper mapper;

  public ExerciseRepositoryImpl(JpaExerciseRepository exerciseRepository, ExerciseMapper mapper) {
    this.exerciseRepository = exerciseRepository;
    this.mapper = mapper;

    createExercise(new CreateExerciseRepoRequest("Push up"));
    createExercise(new CreateExerciseRepoRequest("Pull up"));
  }

  @Override
  public Iterable<Exercise> getExercises() {
    return StreamSupport.stream(exerciseRepository.findAll().spliterator(), false).map(mapper::toExercise).toList();
  }

  @Override
  public Exercise getExerciseReference(UUID id) {
    return mapper.toExercise(exerciseRepository.getReferenceById(id));
  }

  @Override
  public Exercise createExercise(CreateExerciseRepoRequest request) {
    var exercise = new ExerciseEntity(request.name());
    return mapper.toExercise(exerciseRepository.save(exercise));
  }

}
