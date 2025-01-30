package com.marmouset.workout.external.database.exercise.trained;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.marmouset.workout.external.database.workout.WorkoutLogEntity;

public interface JpaTrainedExerciseRepository extends CrudRepository<TrainedExerciseEntity, UUID> {
  Iterable<TrainedExerciseEntity> findByLog(WorkoutLogEntity log);
}
