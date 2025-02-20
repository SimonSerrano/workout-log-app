package com.marmouset.workout.external.web.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponseBuilder;
import com.marmouset.workout.app.port.out.set.ExerciseSetPresenter;
import org.springframework.stereotype.Component;

@Component
class TrainedExercisePresenterImpl implements TrainedExercisePresenter {

  private final ExercisePresenter exercisePresenter;
  private final ExerciseSetPresenter exerciseSetPresenter;

  TrainedExercisePresenterImpl(ExercisePresenter exercisePresenter,
                               ExerciseSetPresenter exerciseSetPresenter) {
    this.exercisePresenter = exercisePresenter;
    this.exerciseSetPresenter = exerciseSetPresenter;
  }

  @Override
  public TrainedExerciseResponse present(TrainedExercise exercise) {
    var response = new TrainedExerciseResponseBuilder()
        .setId(exercise.getId())
        .setLogId(exercise.getLogId())
        .setExercise(exercisePresenter.present(exercise.getExercise()))
        .setSets(exercise.getSets()
            .stream().map(exerciseSetPresenter::present).toList());
    exercise.getWeight().ifPresent(response::setWeight);
    return response.build();
  }
}
