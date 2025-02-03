package com.marmouset.workout.app.usecase.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.workout.UpdateWorkoutLog;
import com.marmouset.workout.app.port.in.workout.UpdateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.workout.UpdateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import com.marmouset.workout.external.database.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
class UpdateWorkoutLogUseCase implements UpdateWorkoutLog {

  private final WorkoutLogRepository repository;
  private final WorkoutLogPresenter presenter;

  UpdateWorkoutLogUseCase(WorkoutLogRepository repository,
                          WorkoutLogPresenter presenter) {
    this.repository = repository;
    this.presenter = presenter;
  }

  @Override
  public WorkoutLogResponse update(UpdateWorkoutLogCommand command)
      throws WorkoutLogNotFoundException {
    try {
      return presenter.present(repository.update(
          new UpdateWorkoutLogRepoRequest(command.id(), command.name())));
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(command.id());
    }
  }
}
