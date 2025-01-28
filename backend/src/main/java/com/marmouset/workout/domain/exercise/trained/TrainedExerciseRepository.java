package com.marmouset.workout.domain.exercise.trained;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface TrainedExerciseRepository extends CrudRepository<TrainedExercise, UUID> {

}
