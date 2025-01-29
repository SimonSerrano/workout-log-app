package com.marmouset.workout.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

public interface TrainedExerciseRepository extends CrudRepository<TrainedExercise, UUID> {
  Iterable<TrainedExercise> findByLog(WorkoutLog log);
}
