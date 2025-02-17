package com.marmouset.workout.app.usecase.workout;

import com.marmouset.workout.app.port.in.workout.ListWorkoutLogs;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Use case for listing the workout logs.
 */
@Component
public class ListWorkoutLogsUseCase implements ListWorkoutLogs {
  private final WorkoutLogRepository repository;
  private final WorkoutLogPresenter presenter;

  /**
   * Constructor for this use case.
   *
   * @param repository the workout logContainer repository
   * @param presenter  the presenter for workout logs
   */
  public ListWorkoutLogsUseCase(WorkoutLogRepository repository,
                                WorkoutLogPresenter presenter) {
    this.repository = repository;
    this.presenter = presenter;
  }


  @Override
  public List<WorkoutLogResponse> list() {
    return repository.read().stream()
        .map(presenter::present)
        .toList();
  }
}
