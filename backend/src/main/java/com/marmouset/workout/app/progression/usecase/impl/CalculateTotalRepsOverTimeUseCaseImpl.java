package com.marmouset.workout.app.progression.usecase.impl;


import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.progression.adapter.RepsOverTimeResponse;
import com.marmouset.workout.app.progression.adapter.RepsOverTimeResponsePresenter;
import com.marmouset.workout.app.progression.entity.TotalNumberOfRepetitionsRecord;
import com.marmouset.workout.app.progression.entity.TotalNumberOfRepetitionsRecordFactory;
import com.marmouset.workout.app.progression.usecase.CalculateTotalRepsOverTimeUseCase;
import com.marmouset.workout.app.progression.usecase.dto.CalculateTotalRepsOverTimeCommand;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.GetTrainedExerciseByExerciseIdRepoRequest;
import java.util.List;

public class CalculateTotalRepsOverTimeUseCaseImpl
    implements CalculateTotalRepsOverTimeUseCase {

  private final ExerciseRepository exerciseRepository;
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final TotalNumberOfRepetitionsRecordFactory factory;
  private final RepsOverTimeResponsePresenter presenter;

  public CalculateTotalRepsOverTimeUseCaseImpl(
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

      return presenter.present(exercise.getId(), chart);
    } catch (NotFoundException e) {
      throw new ExerciseNotFoundException(command.exerciseId());
    }
  }

}
