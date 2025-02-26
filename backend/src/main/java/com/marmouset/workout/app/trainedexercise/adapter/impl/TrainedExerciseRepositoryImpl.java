package com.marmouset.workout.app.trainedexercise.adapter.impl;

import com.marmouset.workout.app.exerciseset.entity.ExerciseSetFactory;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseRepositoryGateway;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExerciseFactory;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.GetTrainedExerciseByExerciseIdRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;

/**
 * Converts data from the use cases to the db and vice versa. This is
 * for the trained exercises only
 */
public class TrainedExerciseRepositoryImpl
    implements TrainedExerciseRepository {

  private final TrainedExerciseRepositoryGateway repositoryGateway;
  private final TrainedExerciseFactory trainedExerciseFactory;
  private final ExerciseSetFactory exerciseSetFactory;

  /**
   * Creates a TrainedExerciseRepositoryImpl.
   *
   * @param repositoryGateway      the gateway
   * @param trainedExerciseFactory the trained exercise factory
   * @param exerciseSetFactory     the exercise set factory
   */
  public TrainedExerciseRepositoryImpl(
      TrainedExerciseRepositoryGateway repositoryGateway,
      TrainedExerciseFactory trainedExerciseFactory,
      ExerciseSetFactory exerciseSetFactory) {
    this.repositoryGateway = repositoryGateway;
    this.trainedExerciseFactory = trainedExerciseFactory;
    this.exerciseSetFactory = exerciseSetFactory;
  }

  @Override
  public List<? extends TrainedExercise> read(WorkoutLog log) {
    return repositoryGateway.findByLog(log);
  }

  @Override
  public TrainedExercise create(
      CreateTrainedExerciseRepoRequest request) {
    var entity = trainedExerciseFactory.create()
        .setExercise(request.exercise())
        .setLog(request.log()).addAllSets(request.sets().stream().map(
            exerciseSetFactory::create
        ).toList())
        .setWeight(request.weight());

    return repositoryGateway.save(entity);
  }

  @Override
  public void delete(DeleteTrainedExerciseRepoRequest request) {
    repositoryGateway.deleteById(request.trainedId());
  }

  @Override
  public TrainedExercise update(UpdateTrainedExerciseRepoRequest request)
      throws NotFoundException {
    var entity = repositoryGateway
        .findById(request.trainedId()).orElseThrow(NotFoundException::new)
        .setExercise(request.exercise())
        .addAllSets(
            request.sets().stream().map(exerciseSetFactory::create).toList())
        .setWeight(request.weight());
    return repositoryGateway.save(entity);
  }

  @Override
  public List<TrainedExercise> getTrainedExerciseByExerciseId(
      GetTrainedExerciseByExerciseIdRepoRequest request) {
    throw new IllegalStateException("Not yet implemented");
  }
}
