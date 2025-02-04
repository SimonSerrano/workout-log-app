package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.external.database.workout.WorkoutLogEntity;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

interface JpaTrainedExerciseRepository extends
    ListCrudRepository<TrainedExerciseEntity, TrainedExercisePrimaryKey> {
  List<TrainedExerciseEntity> findByLog(WorkoutLogEntity log);
}
