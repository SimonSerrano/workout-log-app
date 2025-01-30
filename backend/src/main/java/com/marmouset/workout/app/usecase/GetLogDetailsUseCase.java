package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.port.in.GetLogDetails;
import com.marmouset.workout.app.port.out.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

@Component
public class GetLogDetailsUseCase implements GetLogDetails {
  private final WorkoutLogRepository workoutLogRepository;
  private final WorkoutLogPresenter presenter;

  public GetLogDetailsUseCase(WorkoutLogRepository workoutLogRepository, WorkoutLogPresenter presenter) {
    this.workoutLogRepository = workoutLogRepository;
    this.presenter = presenter;
  }

  @Override
  public WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFound {
    return presenter.prepareSuccessfulResponse(workoutLogRepository.getLogDetails(uuid));
  }
}
