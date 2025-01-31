package com.marmouset.workout.app.port.out.dto;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.set.ExerciseSet;
import java.util.List;

/**
 * Response for the trained exercise.
 *
 * @param exercise the trained exercise
 * @param sets     the sets for that exercise
 */
public record TrainedExerciseResponse(Exercise exercise,
                                      List<ExerciseSet> sets) {


}
