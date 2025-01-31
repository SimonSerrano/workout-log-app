package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.port.in.workout.ListWorkoutLogs;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
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
   * @param repository the workout log repository
   * @param presenter  the presenter for workout logs
   */
  public ListWorkoutLogsUseCase(WorkoutLogRepository repository,
                                WorkoutLogPresenter presenter) {
    this.repository = repository;
    this.presenter = presenter;
  }


  @Override
  public Iterable<WorkoutLogResponse> listWorkouts() {
    return repository.getAllLogs().stream()
        .map(presenter::present)
        .toList();
  }
}
