package com.marmouset.workout.external.database.exercise;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExerciseRepository extends JpaRepository<ExerciseEntity, UUID> {

}
