package com.marmouset.workout.app.usecase;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListWorkoutLogs;
import com.marmouset.workout.app.port.out.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

@Component
public class ListWorkoutLogsUseCase implements ListWorkoutLogs {
  private final WorkoutLogRepository workoutLogRepository;
  private final WorkoutLogPresenter presenter;

  public ListWorkoutLogsUseCase(WorkoutLogRepository workoutLogRepository, WorkoutLogPresenter presenter) {
    this.workoutLogRepository = workoutLogRepository;
    this.presenter = presenter;
  }

  @Override
  public Iterable<WorkoutLogResponse> listWorkouts() {
    return StreamSupport
        .stream(workoutLogRepository.getAllLogs().spliterator(), false)
        .map(presenter::prepareSuccessfulResponse)
        .toList();
  }
}
