package com.marmouset.workout.app.workout.external.spring.database;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to declare the JPA repository for workout logs.
 */
public interface JpaWorkoutLogRepository
    extends JpaRepository<WorkoutLogImpl, UUID> {

  /**
   * Find all workout logs ordered descending by the createdAt field.
   *
   * @return a list of workout logs
   */
  List<WorkoutLogImpl> findAllByOrderByCreatedAtDesc();
}


