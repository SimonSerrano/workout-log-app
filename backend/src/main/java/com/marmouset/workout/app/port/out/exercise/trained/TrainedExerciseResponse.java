package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import java.util.List;
import java.util.UUID;

/**
 * Response for the trained exercise.
 *
 * @param id       the id
 * @param logId    the workout log id
 * @param exercise the trained exercise
 * @param sets     the sets for that exercise
 */
public record TrainedExerciseResponse(Long id, UUID logId,
                                      ExerciseResponse exercise,
                                      List<ExerciseSetResponse> sets) {


}
