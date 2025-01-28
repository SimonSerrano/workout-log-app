package com.marmouset.workout.adapter.out.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.domain.WorkoutLog;

@SpringBootTest
public class WorkoutLogResponseMapperTest {

  private WorkoutLogResponseMapper adapter;

  @BeforeEach
  void setup() {
    adapter = new WorkoutLogResponseMapper();
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

    assertEquals(new WorkoutLogListElementResponse(uuid, "Toto", timestamp), dto);

  }
}
