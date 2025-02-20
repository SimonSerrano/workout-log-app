package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
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
