package com.marmouset.workout.external.database.set;

import org.springframework.stereotype.Repository;

@Repository
class ExerciseSetRepositoryImpl {

  private final JpaExerciseSetRepository trainedExerciseRepository;
  private final ExerciseSetMapper mapper;

  public ExerciseSetRepositoryImpl(JpaExerciseSetRepository trainedExerciseRepository,
      ExerciseSetMapper mapper) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.mapper = mapper;
  }

}
