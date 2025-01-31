package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import java.util.List;

/**
 * Response for the trained exercise.
 *
 * @param exercise the trained exercise
 * @param sets     the sets for that exercise
 */
public record TrainedExerciseResponse(ExerciseResponse exercise,
                                      List<ExerciseSetResponse> sets) {


}
