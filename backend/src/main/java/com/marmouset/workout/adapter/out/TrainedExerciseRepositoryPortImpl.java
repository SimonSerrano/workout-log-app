package com.marmouset.workout.adapter.out;

import org.springframework.stereotype.Repository;

import com.marmouset.workout.adapter.out.persistence.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.TrainedExerciseRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

@Repository
public class TrainedExerciseRepositoryPortImpl implements TrainedExerciseRepositoryPort {

  private final TrainedExerciseRepository trainedExerciseRepository;

  public TrainedExerciseRepositoryPortImpl(TrainedExerciseRepository trainedExerciseRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
  }

  @Override
  public Iterable<TrainedExercise> getTrainedExercises(WorkoutLog log) {
    return trainedExerciseRepository.findByLog(log);
  }

  @Override
  public TrainedExercise createTrainedExercise(TrainedExercise trainedExercise) {
    return trainedExerciseRepository.save(trainedExercise);
  }

}
