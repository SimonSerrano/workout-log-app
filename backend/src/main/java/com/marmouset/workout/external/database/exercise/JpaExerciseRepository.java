package com.marmouset.workout.external.database.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

interface JpaExerciseRepository extends
    JpaRepository<ExerciseEntityImpl, String> {

}
