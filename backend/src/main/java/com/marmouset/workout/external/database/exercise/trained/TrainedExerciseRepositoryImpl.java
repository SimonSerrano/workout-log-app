package com.marmouset.workout.external.database.exercise.trained;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.dto.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.external.database.exercise.ExerciseEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntity;

@Repository
public class TrainedExerciseRepositoryImpl implements TrainedExerciseRepository {

  private final JpaTrainedExerciseRepository trainedExerciseRepository;
  private final TrainedExerciseMapper mapper;

  public TrainedExerciseRepositoryImpl(JpaTrainedExerciseRepository trainedExerciseRepository,
      TrainedExerciseMapper mapper) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.mapper = mapper;
  }

  @Override
  public Iterable<TrainedExercise> getTrainedExercises(WorkoutLog log) {
    var entity = new WorkoutLogEntity();
    entity.setId(log.getId());
    return StreamSupport.stream(trainedExerciseRepository.findByLog(entity).spliterator(), false)
        .map(mapper::toTrainedExercise).toList();
  }

  @Override
  public TrainedExercise createTrainedExercise(CreateTrainedExerciseRepoRequest request) {
    var entity = new TrainedExerciseEntity();
    entity.setExercise(new ExerciseEntity());
    entity.setLog(new WorkoutLogEntity());
    return mapper.toTrainedExercise(trainedExerciseRepository.save(entity));
  }

}
