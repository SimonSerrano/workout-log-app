package com.marmouset.workout.app.exercise.external.spring.database;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to declare a JPA repository of ExerciseImpl.
 */
public interface JpaExerciseRepository extends
    JpaRepository<ExerciseImpl, String> {

}
