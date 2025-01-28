package com.marmouset.workout.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.marmouset.workout.domain.exercise.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, UUID> {

}
