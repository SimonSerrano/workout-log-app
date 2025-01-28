package com.marmouset.workout.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marmouset.workout.domain.WorkoutLog;

public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, UUID> {

}
