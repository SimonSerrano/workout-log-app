package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.workout.impl.WorkoutLogImpl;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ListWorkoutLogsUseCaseTest {

  @MockitoBean
  private WorkoutLogRepository repository;

  @Autowired
  private WorkoutLogPresenter presenter;

  private ListWorkoutLogsUseCase useCase;

  @BeforeEach
  void setUp() {
    useCase = new ListWorkoutLogsUseCase(repository, presenter);
  }

  @Test
  void shouldReturnWorkoutLogs() {
    var log1 = new WorkoutLogImpl(UUID.randomUUID(), "Toto", Instant.now());
    var log2 = new WorkoutLogImpl(UUID.randomUUID(), "Titi", Instant.now());

    var expected1 = new WorkoutLogResponse(log1.getId(), log1.getName(),
        log1.getCreatedAt().getEpochSecond());
    var expected2 = new WorkoutLogResponse(log2.getId(), log2.getName(),
        log2.getCreatedAt().getEpochSecond());

    when(repository.getAllLogs()).thenReturn(List.of(
        log1,
        log2
    ));


    var result = useCase.list().iterator();
    assertEquals(expected1, result.next());
    assertEquals(expected2, result.next());
  }

  @Test
  void shouldReturnEmptyWorkoutLogs() {
    when(repository.getAllLogs()).thenReturn(Collections.emptyList());
    assertTrue(useCase.list().isEmpty());
  }
}