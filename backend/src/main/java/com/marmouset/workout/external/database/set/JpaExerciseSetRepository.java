package com.marmouset.workout.external.database.set;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

interface JpaExerciseSetRepository extends CrudRepository<ExerciseSetEntity, UUID> {

}
