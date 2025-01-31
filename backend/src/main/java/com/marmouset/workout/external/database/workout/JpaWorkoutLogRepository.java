package com.marmouset.workout.external.database.workout;

import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;

interface JpaWorkoutLogRepository
    extends ListCrudRepository<WorkoutLogEntity, UUID> {

}


