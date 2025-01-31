package com.marmouset.workout.app.usecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class DeleteWorkoutLogUseCaseTest {

  @MockitoBean
  private WorkoutLogRepository repository;

  private DeleteWorkoutLogUseCase useCase;

  @BeforeEach
  void setUp() {
    useCase = new DeleteWorkoutLogUseCase(repository);
  }

  @Test
  void shouldCallRepository() {
    var id = UUID.randomUUID();
    useCase.delete(id);
    verify(repository, times(1)).delete(id);
  }
}