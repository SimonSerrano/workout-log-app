package com.marmouset.workout.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marmouset.workout.domain.exercise.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

}
