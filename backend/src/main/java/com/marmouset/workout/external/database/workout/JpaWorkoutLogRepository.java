package com.marmouset.workout.external.database.workout;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaWorkoutLogRepository
    extends JpaRepository<WorkoutLogEntityImpl, UUID> {

  List<WorkoutLogEntityImpl> findAllByOrderByCreatedAtDesc();
}


