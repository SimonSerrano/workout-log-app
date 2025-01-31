package com.marmouset.workout.external.web.set;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.port.out.set.ExerciseSetPresenter;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import org.springframework.stereotype.Component;

@Component
class ExerciseSetPresenterImpl implements ExerciseSetPresenter {
  @Override
  public ExerciseSetResponse present(ExerciseSet exerciseSet) {
    return new ExerciseSetResponse(exerciseSet.getId(), exerciseSet.getReps());
  }
}
