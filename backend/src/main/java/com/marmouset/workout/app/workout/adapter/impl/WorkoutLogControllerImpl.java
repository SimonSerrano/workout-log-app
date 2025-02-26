package com.marmouset.workout.app.workout.adapter.impl;

import com.marmouset.workout.app.workout.adapter.WorkoutLogController;
import com.marmouset.workout.app.workout.adapter.WorkoutLogResponsePresenter;
import com.marmouset.workout.app.workout.adapter.dto.WorkoutLogResponse;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.CreateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.DeleteWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.GetLogDetailsUseCase;
import com.marmouset.workout.app.workout.usecase.ListWorkoutLogsUseCase;
import com.marmouset.workout.app.workout.usecase.UpdateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;
import java.util.List;
import java.util.UUID;

/**
 * Converts data from the web to the use cases for workout logs.
 */
public class WorkoutLogControllerImpl implements WorkoutLogController {


  private final WorkoutLogResponsePresenter presenter;

  private final CreateWorkoutLogUseCase createUseCase;
  private final DeleteWorkoutLogUseCase deleteUseCase;
  private final GetLogDetailsUseCase getUseCase;
  private final ListWorkoutLogsUseCase listUseCase;
  private final UpdateWorkoutLogUseCase updateUseCase;

  /**
   * Creates a WorkoutLogControllerImpl.
   *
   * @param createUseCase the create use case
   * @param deleteUseCase the delete use case
   * @param getUseCase    the get use case
   * @param listUseCase   the list use case
   * @param updateUseCase the update use case
   */
  public WorkoutLogControllerImpl(CreateWorkoutLogUseCase createUseCase,
                                  DeleteWorkoutLogUseCase deleteUseCase,
                                  GetLogDetailsUseCase getUseCase,
                                  ListWorkoutLogsUseCase listUseCase,
                                  UpdateWorkoutLogUseCase updateUseCase) {
    this.presenter = new WorkoutLogResponsePresenterImpl();
    this.createUseCase = createUseCase;
    this.deleteUseCase = deleteUseCase;
    this.getUseCase = getUseCase;
    this.listUseCase = listUseCase;
    this.updateUseCase = updateUseCase;
  }

  @Override
  public WorkoutLogResponse create(CreateWorkoutLogCommand command) {
    return presenter.present(createUseCase.create(command));
  }

  @Override
  public void delete(UUID uuid) {
    deleteUseCase.delete(uuid);
  }

  @Override
  public WorkoutLogResponse get(UUID uuid) throws WorkoutLogNotFoundException {
    return presenter.present(getUseCase.get(uuid));
  }

  @Override
  public List<WorkoutLogResponse> list() {
    return listUseCase.list().stream().map(presenter::present).toList();
  }

  @Override
  public WorkoutLogResponse update(UpdateWorkoutLogCommand command)
      throws WorkoutLogNotFoundException {
    return presenter.present(updateUseCase.update(command));
  }
}
