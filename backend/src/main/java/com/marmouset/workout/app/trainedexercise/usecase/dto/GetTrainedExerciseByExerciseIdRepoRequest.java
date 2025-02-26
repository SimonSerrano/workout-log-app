package com.marmouset.workout.app.trainedexercise.usecase.dto;

import com.marmouset.workout.app.exercise.entity.Exercise;

/**
 * Request to get trained exercises by id.
 *
 * @param exercise the exercise to get
 */
public record GetTrainedExerciseByExerciseIdRepoRequest(Exercise exercise) {
}
