package com.marmouset.workout.app.usecase.exercise.trained;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class DeleteTrainedExerciseUseCaseTest {
  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;
  @MockitoBean
  private WorkoutLogRepository workoutLogRepository;

  private DeleteTrainedExerciseUseCase useCase;

  @BeforeEach
  void setUp() {
    useCase = new DeleteTrainedExerciseUseCase(trainedExerciseRepository,
        workoutLogRepository);
  }

  @Test
  void shouldCallDeleteRepository() throws WorkoutLogNotFoundException {
    var logId = UUID.randomUUID();
    var trainedId = 7L;
    when(workoutLogRepository.exists(logId)).thenReturn(true);
    useCase.delete(logId, trainedId);
    verify(trainedExerciseRepository, times(1))
        .delete(new DeleteTrainedExerciseRepoRequest(trainedId));
  }
}