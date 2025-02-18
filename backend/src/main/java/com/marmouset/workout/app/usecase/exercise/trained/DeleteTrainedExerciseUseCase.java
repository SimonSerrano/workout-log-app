package com.marmouset.workout.app.usecase.exercise.trained;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class DeleteTrainedExerciseUseCase implements DeleteTrainedExercise {
  private final TrainedExerciseRepository trainedExerciseRepository;
  private final WorkoutLogRepository workoutLogRepository;


  public DeleteTrainedExerciseUseCase(
      TrainedExerciseRepository trainedExerciseRepository,
      WorkoutLogRepository workoutLogRepository) {
    this.trainedExerciseRepository = trainedExerciseRepository;
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public void delete(UUID logId, Long trainedId)
      throws WorkoutLogNotFoundException {
    if (!workoutLogRepository.exists(logId)) {
      throw new WorkoutLogNotFoundException(logId);
    }
    trainedExerciseRepository.delete(
        new DeleteTrainedExerciseRepoRequest(trainedId));
  }
}
