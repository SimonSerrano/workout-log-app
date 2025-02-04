package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
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
    var entity = new TrainedExerciseEntity();
    entity.setExercise(new ExerciseEntity());
    entity.setLog(new WorkoutLogEntity());
    return mapper.toTrainedExercise(trainedExerciseRepository.save(entity));
  }

  @Override
  public void delete(DeleteTrainedExerciseRepoRequest request) {
    trainedExerciseRepository.deleteById(
        new TrainedExercisePrimaryKey()
            .setWorkoutLogId(request.logId())
            .setTrainedExerciseId(request.trainedId()));
  }

}
