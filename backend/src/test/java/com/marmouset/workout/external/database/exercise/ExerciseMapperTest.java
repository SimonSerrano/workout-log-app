package com.marmouset.workout.external.database.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseMapperTest {

  @Autowired
  private ExerciseFactory factory;
  private ExerciseMapper mapper;


  @BeforeEach
  void setUp() {
    mapper = new ExerciseMapper(factory);
  }

  @Test
  void shouldMapToExercise() {
    ExerciseEntityImpl entity = new ExerciseEntityImpl();
    entity.setId(UUID.randomUUID());
    entity.setName("Pull up");

    var expected = factory.create(entity.getId(), entity.getName());

    assertEquals(mapper.toExercise(entity), expected);
  }
}