package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.UpdateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
class TrainedExerciseRepositoryImpl implements TrainedExerciseRepository {

  private final JpaTrainedExerciseRepository trainedExerciseRepository;
  private final TrainedExerciseMapper mapper;

  TrainedExerciseRepositoryImpl(
      JpaTrainedExerciseRepository trainedExerciseRepository,
      TrainedExerciseMapper mapper) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.mapper = mapper;
  }

  @Override
  public List<TrainedExercise> read(WorkoutLogEntityContainer log) {
    return trainedExerciseRepository.findByLog(log.reference()).stream()
        .map(mapper::toTrainedExercise).toList();
  }

  @Override
  public TrainedExercise create(
      CreateTrainedExerciseRepoRequest request) {
    var entity = new TrainedExerciseEntity().mutateFrom(request);
    return mapper.toTrainedExercise(trainedExerciseRepository.save(entity));
  }

  @Override
  public void delete(DeleteTrainedExerciseRepoRequest request) {
    trainedExerciseRepository.deleteById(request.trainedId());
  }

  @Override
  public TrainedExercise update(UpdateTrainedExerciseRepoRequest request)
      throws NotFoundException {
    var entity = trainedExerciseRepository
        .findById(request.trainedId()).orElseThrow(NotFoundException::new)
        .mutateFrom(request);
    return mapper.toTrainedExercise(trainedExerciseRepository.save(entity));
  }
}
