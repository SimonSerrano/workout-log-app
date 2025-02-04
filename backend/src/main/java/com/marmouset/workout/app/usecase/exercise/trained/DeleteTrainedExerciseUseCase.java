package com.marmouset.workout.app.usecase.exercise.trained;

import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class DeleteTrainedExerciseUseCase implements DeleteTrainedExercise {
  private final TrainedExerciseRepository repository;

  public DeleteTrainedExerciseUseCase(
      TrainedExerciseRepository repository) {
    this.repository = repository;
  }

  @Override
  public void delete(UUID logId, Long trainedId) {
    repository.delete(new DeleteTrainedExerciseRepoRequest(logId, trainedId));
  }
}
