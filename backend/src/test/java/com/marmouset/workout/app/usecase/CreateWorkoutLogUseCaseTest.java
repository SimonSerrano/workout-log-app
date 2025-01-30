package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.impl.WorkoutLogFactoryImpl;
import com.marmouset.workout.app.port.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class CreateWorkoutLogUseCaseTest {

  @MockitoBean
  private WorkoutLogRepository repository;

  @MockitoBean
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
    when(repository.createWorkoutLog(
        new CreateWorkoutLogRepoRequest(created.getName()))).thenReturn(
        created);
    var expected = new WorkoutLogResponse(created.getId(), created.getName(),
        created.getCreatedAt().getEpochSecond());
    when(presenter.prepareSuccessfulResponse(created)).thenReturn(expected);
    var result = useCase.createWorkoutLog(
        new CreateWorkoutLogCommand(created.getName()));
    assertEquals(expected, result);
  }
}