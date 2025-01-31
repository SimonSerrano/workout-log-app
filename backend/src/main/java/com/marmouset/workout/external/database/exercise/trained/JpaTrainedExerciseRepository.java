package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.external.database.workout.WorkoutLogEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;

interface JpaTrainedExerciseRepository extends
    ListCrudRepository<TrainedExerciseEntity, UUID> {
  List<TrainedExerciseEntity> findByLog(WorkoutLogEntity log);
}
