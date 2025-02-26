package com.marmouset.workout.app.trainedexercise.adapter.dto;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import java.util.List;
import java.util.UUID;

/**
 * Response for the trained exerciseContainer.
 *
 * @param id       the id
 * @param logId    the workout logContainer id
 * @param exercise the trained exerciseContainer
 * @param sets     the sets for that exerciseContainer
 * @param weight   the optional weight
 */
public record TrainedExerciseResponse(Long id, UUID logId,
                                      ExerciseResponse exercise,
                                      List<ExerciseSetResponse> sets,
                                      Integer weight) {


}
