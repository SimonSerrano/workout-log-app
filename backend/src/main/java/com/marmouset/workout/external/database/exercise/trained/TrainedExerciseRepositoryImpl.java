package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.UpdateTrainedExerciseRepoRequest;
import com.marmouset.workout.external.database.exception.NotFoundException;
import com.marmouset.workout.external.database.exercise.ExerciseEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
class TrainedExerciseRepositoryImpl
    implements TrainedExerciseRepository {

  private final JpaTrainedExerciseRepository trainedExerciseRepository;
  private final TrainedExerciseMapper mapper;

  TrainedExerciseRepositoryImpl(
      JpaTrainedExerciseRepository trainedExerciseRepository,
      TrainedExerciseMapper mapper) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.mapper = mapper;
  }

  @Override
  public List<TrainedExercise> read(WorkoutLog log) {
    var entity = new WorkoutLogEntity();
    entity.setId(log.getId());
    return trainedExerciseRepository.findByLog(entity).stream()
        .map(mapper::toTrainedExercise).toList();
  }

  @Override
  public TrainedExercise create(
      CreateTrainedExerciseRepoRequest request) {
    var exercise = new ExerciseEntity();
    exercise.setId(request.exercise().id());
    var workout = new WorkoutLogEntity();
    workout.setId(request.log().getId());
    var entity = new TrainedExerciseEntity();
    entity.setExercise(exercise);
    entity.setLog(workout);
    return mapper.toTrainedExercise(trainedExerciseRepository.save(entity));
  }

  @Override
  public void delete(DeleteTrainedExerciseRepoRequest request) {
    trainedExerciseRepository.deleteById(
        new TrainedExercisePrimaryKey()
            .setWorkoutLogId(request.logId())
            .setTrainedExerciseId(request.trainedId()));
  }

  @Override
  public TrainedExercise update(UpdateTrainedExerciseRepoRequest request)
      throws NotFoundException {
    var exercise = new ExerciseEntity();
    exercise.setId(request.exercise().id());
    var entity = trainedExerciseRepository.findById(
        new TrainedExercisePrimaryKey()
            .setTrainedExerciseId(request.trainedId())
            .setWorkoutLogId(request.log().getId())).orElseThrow(
        NotFoundException::new);
    entity.setExercise(exercise);
    return mapper.toTrainedExercise(trainedExerciseRepository.save(entity));
  }

}
