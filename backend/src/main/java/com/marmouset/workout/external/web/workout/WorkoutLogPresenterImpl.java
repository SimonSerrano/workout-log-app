package com.marmouset.workout.external.web.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import org.springframework.stereotype.Component;

@Component
class WorkoutLogPresenterImpl implements WorkoutLogPresenter {

  @Override
  public WorkoutLogResponse present(WorkoutLog log) {
    return new WorkoutLogResponse(
        log.getId(),
        log.getName(),
        log.getCreatedAt().getEpochSecond());
  }

}
