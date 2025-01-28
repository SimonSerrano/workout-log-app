package com.marmouset.workout.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.marmouset.workout.domain.WorkoutLog;

public interface WorkoutLogRepository extends CrudRepository<WorkoutLog, UUID> {

}
