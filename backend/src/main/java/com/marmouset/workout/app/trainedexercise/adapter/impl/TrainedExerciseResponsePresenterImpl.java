package com.marmouset.workout.app.trainedexercise.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.ExerciseResponsePresenter;
import com.marmouset.workout.app.exerciseset.adapter.ExerciseSetResponsePresenter;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseResponsePresenter;
import com.marmouset.workout.app.trainedexercise.adapter.dto.TrainedExerciseResponse;
import com.marmouset.workout.app.trainedexercise.adapter.dto.TrainedExerciseResponseBuilder;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;

/**
 * Converts data from the use cases to the web for trained exercises.
 */
public class TrainedExerciseResponsePresenterImpl
    implements TrainedExerciseResponsePresenter {

  private final ExerciseResponsePresenter exercisePresenter;
  private final ExerciseSetResponsePresenter exerciseSetResponsePresenter;

  /**
   * Creates a TrainedExerciseResponsePresenterImpl.
   *
   * @param exerciseResponsePresenter    the exercise presenter
   * @param exerciseSetResponsePresenter the exercise set presenter
   */
  public TrainedExerciseResponsePresenterImpl(
      ExerciseResponsePresenter exerciseResponsePresenter,
      ExerciseSetResponsePresenter exerciseSetResponsePresenter) {
    this.exercisePresenter = exerciseResponsePresenter;
    this.exerciseSetResponsePresenter = exerciseSetResponsePresenter;
  }

  @Override
  public TrainedExerciseResponse present(TrainedExercise exercise) {
    var response = new TrainedExerciseResponseBuilder()
        .setId(exercise.getId())
        .setLogId(exercise.getLogId())
        .setExercise(
            exercisePresenter.present(exercise.getExercise()))
        .setSets(exercise.getSets()
            .stream().map(exerciseSetResponsePresenter::present).toList());
    exercise.getWeight().ifPresent(response::setWeight);
    return response.build();
  }
}
