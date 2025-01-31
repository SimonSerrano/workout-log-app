package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.impl.WorkoutLogFactoryImpl;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.workout.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class CreateWorkoutLogUseCaseTest {

  @MockitoBean
  private WorkoutLogRepository repository;

  @Autowired
  private WorkoutLogPresenter presenter;


  private CreateWorkoutLogUseCase useCase;

  private WorkoutLogFactory factory;

  @BeforeEach
  void setUp() {
    useCase = new CreateWorkoutLogUseCase(repository, presenter);
    factory = new WorkoutLogFactoryImpl();
  }

  @Test
  void shouldCreateAndReturnWorkoutLog() {
    var created = factory.create(UUID.randomUUID(), "Toto", Instant.now());
    when(repository.create(
        new CreateWorkoutLogRepoRequest(created.getName()))).thenReturn(
        created);
    var expected = new WorkoutLogResponse(created.getId(), created.getName(),
        created.getCreatedAt().getEpochSecond());
    var result = useCase.create(
        new CreateWorkoutLogCommand(created.getName()));
    assertEquals(expected, result);
  }
}