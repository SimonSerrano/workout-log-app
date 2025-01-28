package com.marmouset.workout.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkoutLogAdapterTest {

  private WorkoutLogAdapter adapter;

  @BeforeEach
  void setup() {
    adapter = new WorkoutLogAdapter();
  }

  @Test
  void shouldReturnWorkoutLogListElementDTO() {
    var timestamp = 1738071414L;
    var uuid = UUID.randomUUID();
    var createdAt = LocalDateTime.ofEpochSecond(1738071414, 0, ZoneOffset.UTC);
    var workoutLog = new WorkoutLog("Toto");
    workoutLog.setId(uuid);
    workoutLog.setCreatedAt(createdAt);

    var dto = adapter.toWorkoutLogListElementDTO(workoutLog);

    assertEquals(new WorkoutLogListElementDTO(uuid, "Toto", timestamp), dto);

  }
}
