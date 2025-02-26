package com.marmouset.workout.app.trainedexercise.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.impl.ExerciseResponsePresenterImpl;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.exerciseset.adapter.impl.ExerciseSetResponsePresenterImpl;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseController;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseResponsePresenter;
import com.marmouset.workout.app.trainedexercise.adapter.dto.TrainedExerciseResponse;
import com.marmouset.workout.app.trainedexercise.usecase.CreateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.DeleteTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.ListTrainedExercisesUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.UpdateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * Converts data from the web to the use cases for trained exercises.
 */
public class TrainedExerciseControllerImpl
    implements TrainedExerciseController {

  private final TrainedExerciseResponsePresenter presenter;
  private final CreateTrainedExerciseUseCase createUseCase;
  private final DeleteTrainedExerciseUseCase deleteUseCase;
  private final ListTrainedExercisesUseCase listUseCase;
  private final UpdateTrainedExerciseUseCase updateUseCase;

  /**
   * Creates a TrainedExerciseControllerImpl.
   *
   * @param createUseCase the create use case
   * @param deleteUseCase the delete use case
   * @param listUseCase   the list use case
   * @param updateUseCase the update use case
   */
  public TrainedExerciseControllerImpl(
      CreateTrainedExerciseUseCase createUseCase,
      DeleteTrainedExerciseUseCase deleteUseCase,
      ListTrainedExercisesUseCase listUseCase,
      UpdateTrainedExerciseUseCase updateUseCase) {
    this.presenter = new TrainedExerciseResponsePresenterImpl(
        new ExerciseResponsePresenterImpl(),
        new ExerciseSetResponsePresenterImpl()
    );
    this.createUseCase = createUseCase;
    this.deleteUseCase = deleteUseCase;
    this.listUseCase = listUseCase;
    this.updateUseCase = updateUseCase;
  }

  @Override
  public TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFoundException, WorkoutLogNotFoundException {
    return presenter.present(createUseCase.create(command));
  }

  @Override
  public void delete(UUID logId, Long trainedId)
      throws WorkoutLogNotFoundException {
    deleteUseCase.delete(logId, trainedId);
  }

  @Override
  public List<TrainedExerciseResponse> list(UUID logId)
      throws WorkoutLogNotFoundException {
    return listUseCase.list(logId).stream().map(presenter::present).toList();
  }

  @Override
  public TrainedExerciseResponse update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException {
    return presenter.present(updateUseCase.update(command));
  }
}
