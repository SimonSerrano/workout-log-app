package com.marmouset.workout.external.database.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.set.ExerciseSetFactory;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseSetMapperTest {

  @Autowired
  private ExerciseSetFactory factory;

  private ExerciseSetMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ExerciseSetMapper(factory);
  }

  @Test
  void shouldReturnMappedSet() {
    var entity = new ExerciseSetEntity();
    entity.TEST_ONLY_setId(UUID.randomUUID());
    entity.setReps(99);

    var expected = factory.create(entity.getId(), entity.getReps());
    assertEquals(expected, mapper.toExerciseSet(entity));
  }
}