package com.marmouset.workout.app.exercise.practice;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface PracticeRepository extends CrudRepository<Practice, UUID> {

}
