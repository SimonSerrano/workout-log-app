package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.impl.WorkoutLogFactoryImpl;
import com.marmouset.workout.app.port.out.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class GetLogDetailsUseCaseTest {

  @MockitoBean
  private WorkoutLogRepository repository;
  @MockitoBean
  private WorkoutLogPresenter presenter;

  private GetLogDetailsUseCase useCase;

  private WorkoutLogFactory factory;

  @BeforeEach
  void setUp() {
    useCase = new GetLogDetailsUseCase(repository, presenter);
    factory = new WorkoutLogFactoryImpl();
  }

  @Test
  void shouldReturnWorkoutLog() throws WorkoutLogNotFound {
    var log = factory.create(UUID.randomUUID(), "Toto", Instant.now());
    var expected = new WorkoutLogResponse(log.getId(), log.getName(),
        log.getCreatedAt().getEpochSecond());
    when(repository.getLogDetails(log.getId())).thenReturn(log);
    when(presenter.prepareSuccessfulResponse(log)).thenReturn(expected);

    assertEquals(expected, useCase.getDetails(log.getId()));
  }

  @Test
  void shouldThrowWorkoutLogNotFound() throws WorkoutLogNotFound {
    var id = UUID.randomUUID();
    when(repository.getLogDetails(id)).thenThrow(new WorkoutLogNotFound(id));
    assertThrows(WorkoutLogNotFound.class, () -> useCase.getDetails(id));
  }
}