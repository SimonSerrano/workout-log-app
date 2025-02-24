package com.marmouset.workout.app.usecase.progression;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.progression.TotalNumberOfRepetitionsRecord;
import com.marmouset.workout.app.domain.progression.TotalNumberOfRepetitionsRecordFactory;
import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.port.in.progression.CalculateTotalRepsOverTime;
import com.marmouset.workout.app.port.in.progression.CalculateTotalRepsOverTimeCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.GetTrainedExerciseByExerciseIdRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.progression.RepsOverTimeResponse;
import com.marmouset.workout.app.port.out.progression.RepsOverTimeResponsePresenter;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;

public class CalculateTotalRepsOverTimeUseCase
    implements CalculateTotalRepsOverTime {

  private final ExerciseRepository exerciseRepository;
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final TotalNumberOfRepetitionsRecordFactory factory;
  private final RepsOverTimeResponsePresenter presenter;

  public CalculateTotalRepsOverTimeUseCase(
      ExerciseRepository exerciseRepository,
      TrainedExerciseRepository trainedExerciseRepository,
      TotalNumberOfRepetitionsRecordFactory factory,
      RepsOverTimeResponsePresenter presenter) {
    this.exerciseRepository = exerciseRepository;
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.factory = factory;
    this.presenter = presenter;
  }

  @Override
  public RepsOverTimeResponse calculate(
      CalculateTotalRepsOverTimeCommand command)
      throws ExerciseNotFoundException {
    try {
      var exercise = exerciseRepository.readReference(command.exerciseId());
      var trainedExercises = trainedExerciseRepository
          .getTrainedExerciseByExerciseId(
              new GetTrainedExerciseByExerciseIdRepoRequest(exercise)
          );

      List<TotalNumberOfRepetitionsRecord> chart =
          trainedExercises.stream().map(
              trained -> factory.create(
                  trained.getWorkoutDate(),
                  trained.getSets().stream().map(ExerciseSet::getReps)
                      .mapToInt(Integer::intValue).sum())
          ).toList();

      return presenter.present(exercise.reference().getId(), chart);
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }
  }

}
