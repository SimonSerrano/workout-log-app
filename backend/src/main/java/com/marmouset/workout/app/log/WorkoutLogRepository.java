package com.marmouset.workout.app.log;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface WorkoutLogRepository extends CrudRepository<WorkoutLog, UUID> {

}
