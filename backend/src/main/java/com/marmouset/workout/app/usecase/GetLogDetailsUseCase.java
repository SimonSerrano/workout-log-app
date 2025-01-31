package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.workout.GetLogDetails;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class GetLogDetailsUseCase implements GetLogDetails {
  private final WorkoutLogRepository workoutLogRepository;
  private final WorkoutLogPresenter presenter;

  GetLogDetailsUseCase(WorkoutLogRepository workoutLogRepository,
                       WorkoutLogPresenter presenter) {
    this.workoutLogRepository = workoutLogRepository;
    this.presenter = presenter;
  }

  @Override
  public WorkoutLogResponse get(UUID uuid) throws
      WorkoutLogNotFoundException {
    try {
      return presenter.present(
          workoutLogRepository.getLogDetails(uuid));
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(uuid);
    }
  }
}
