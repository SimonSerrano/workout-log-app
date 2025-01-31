package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.domain.workout.impl.WorkoutLogFactoryImpl;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class GetLogDetailsUseCaseTest {

  @MockitoBean
  private WorkoutLogRepository repository;
  @Autowired
  private WorkoutLogPresenter presenter;

  private GetLogDetailsUseCase useCase;

  private WorkoutLogFactory factory;

  @BeforeEach
  void setUp() {
    useCase = new GetLogDetailsUseCase(repository, presenter);
    factory = new WorkoutLogFactoryImpl();
  }

  @Test
  void shouldReturnWorkoutLog() throws NotFoundException,
      WorkoutLogNotFoundException {
    var log = factory.create(UUID.randomUUID(), "Toto", Instant.now());
    var expected = new WorkoutLogResponse(log.getId(), log.getName(),
        log.getCreatedAt().getEpochSecond());
    when(repository.getLogDetails(log.getId())).thenReturn(log);

    assertEquals(expected, useCase.getDetails(log.getId()));
  }

  @Test
  void shouldThrowWorkoutLogNotFound() throws NotFoundException {
    var id = UUID.randomUUID();
    when(repository.getLogDetails(id)).thenThrow(new NotFoundException());
    assertThrows(WorkoutLogNotFoundException.class,
        () -> useCase.getDetails(id));
  }
}