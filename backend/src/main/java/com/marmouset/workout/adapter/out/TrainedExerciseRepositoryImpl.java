package com.marmouset.workout.adapter.out;

import java.util.UUID;

import org.springframework.context.annotation.Lazy;

import com.marmouset.workout.adapter.out.persistence.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.TrainedExerciseRepositoryPort;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

public class TrainedExerciseRepositoryImpl implements TrainedExerciseRepositoryPort {

  private final TrainedExerciseRepository trainedExerciseRepository;

  public TrainedExerciseRepositoryImpl(@Lazy TrainedExerciseRepository trainedExerciseRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
  }

  @Override
  public Iterable<TrainedExercise> getTrainedExercises(UUID logId) {
    return trainedExerciseRepository.findByLog(logId);
  }

  @Override
  public TrainedExercise createTrainedExercise(TrainedExercise trainedExercise) {
    return trainedExerciseRepository.save(trainedExercise);
  }

}
