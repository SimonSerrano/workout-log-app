package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.port.in.GetLogDetails;
import com.marmouset.workout.app.port.out.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;
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
  public WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFound {
    try {
      return presenter.prepareSuccessfulResponse(
          workoutLogRepository.getLogDetails(uuid));
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFound(uuid);
    }
  }
}
