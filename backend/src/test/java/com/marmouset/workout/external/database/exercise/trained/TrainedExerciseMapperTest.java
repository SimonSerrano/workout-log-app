package com.marmouset.workout.external.database.exercise.trained;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.set.ExerciseSetFactory;
import com.marmouset.workout.external.database.exercise.ExerciseEntityImpl;
import com.marmouset.workout.external.database.exercise.ExerciseMapper;
import com.marmouset.workout.external.database.set.ExerciseSetEntity;
import com.marmouset.workout.external.database.set.ExerciseSetMapper;
import com.marmouset.workout.external.database.workout.WorkoutLogEntityImpl;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrainedExerciseMapperTest {


  @Autowired
  private TrainedExerciseFactory trainedExerciseFactory;

  @Autowired
  private ExerciseFactory exerciseFactory;

  @Autowired
  private ExerciseSetFactory exerciseSetFactory;

  private TrainedExerciseMapper mapper;
  @Autowired
  private ExerciseMapper exerciseMapper;
  @Autowired
  private ExerciseSetMapper exerciseSetMapper;

  @BeforeEach
  void setUp() {
    mapper = new TrainedExerciseMapper(
        trainedExerciseFactory,
        exerciseMapper,
        exerciseSetMapper);
  }

  @Test
  void shouldReturnedMapped() {

    var setEntity1 = new ExerciseSetEntity();
    setEntity1.TEST_ONLY_setId(1L);
    setEntity1.setReps(10);
    var setEntity2 = new ExerciseSetEntity();
    setEntity2.TEST_ONLY_setId(2L);
    setEntity2.setReps(13);
    ExerciseEntityImpl exerciseEntity = new ExerciseEntityImpl();
    exerciseEntity.setName("Pull ups");
    var workout = new WorkoutLogEntityImpl();
    workout.TEST_ONLY_setId(UUID.randomUUID());
    var trainedEntity = new TrainedExerciseEntity();
    trainedEntity.TEST_ONLY_setId(1L);
    trainedEntity.setSets(List.of(setEntity1, setEntity2));
    trainedEntity.setExercise(exerciseEntity);
    trainedEntity.setLog(workout);


    var exercise = exerciseFactory.create(
        exerciseEntity.getName());
    var set1 =
        exerciseSetFactory.create(setEntity1.getId(), setEntity1.getReps());
    var set2 =
        exerciseSetFactory.create(setEntity2.getId(), setEntity2.getReps());
    var expected =
        trainedExerciseFactory.create(
            trainedEntity.getId(),
            trainedEntity.getLog().getId(),
            exercise);
    expected.addSet(set1);
    expected.addSet(set2);

    var result = mapper.toTrainedExercise(trainedEntity);
    assertEquals(expected, result);

  }
}