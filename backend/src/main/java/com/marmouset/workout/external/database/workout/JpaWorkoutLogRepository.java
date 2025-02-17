package com.marmouset.workout.external.database.workout;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaWorkoutLogRepository
    extends JpaRepository<WorkoutLogEntityImpl, UUID> {

}


