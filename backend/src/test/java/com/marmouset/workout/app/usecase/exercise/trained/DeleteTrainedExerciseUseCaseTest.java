package com.marmouset.workout.app.usecase.exercise.trained;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.marmouset.workout.app.port.out.exercise.trained.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class DeleteTrainedExerciseUseCaseTest {
  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;

  private DeleteTrainedExerciseUseCase useCase;

  @BeforeEach
  void setUp() {
    useCase = new DeleteTrainedExerciseUseCase(trainedExerciseRepository);
  }

  @Test
  void shouldCallDeleteRepository() {
    var logId = UUID.randomUUID();
    var trainedId = 7L;
    useCase.delete(logId, trainedId);
    verify(trainedExerciseRepository, times(1))
        .delete(new DeleteTrainedExerciseRepoRequest(logId, trainedId));
  }
}