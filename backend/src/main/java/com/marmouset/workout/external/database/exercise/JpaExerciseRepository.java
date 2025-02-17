package com.marmouset.workout.external.database.exercise;

import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;

interface JpaExerciseRepository extends
    ListCrudRepository<ExerciseEntityImpl, UUID> {

}
