package com.marmouset.workout.external.database.workout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkoutLogMapperTest {

  @Autowired
  private WorkoutLogFactory factory;
  private WorkoutLogMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new WorkoutLogMapper(factory);
  }

  @Test
  void shouldReturnMappedWorkoutLog() {
    var entity = new WorkoutLogEntityImpl();
    entity.setName("Leg workout");
    entity.TEST_ONLY_setId(UUID.randomUUID());
    entity.setCreatedAt(Instant.now());

    var expected = factory.create(
        entity.getId(),
        entity.getName(),
        entity.getCreatedAt());

    assertEquals(expected, mapper.toWorkoutLog(entity));

  }
}