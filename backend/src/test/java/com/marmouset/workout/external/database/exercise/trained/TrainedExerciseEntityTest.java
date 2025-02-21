package com.marmouset.workout.external.database.exercise.trained;

import static org.junit.jupiter.api.AssertionFailureBuilder.assertionFailure;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequestBuilder;
import com.marmouset.workout.external.database.exercise.ExerciseEntityImpl;
import com.marmouset.workout.external.database.set.ExerciseSetEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntityImpl;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TrainedExerciseEntityTest {


  @Test
  void shouldMutateFromCreationRequest() {
    var workout = new WorkoutLogEntityImpl();
    var exercise = new ExerciseEntityImpl();
    var sets = List.of(3, 4, 6);
    var entity = new TrainedExerciseEntity()
        .mutateFrom(new CreateTrainedExerciseRepoRequestBuilder()
            .setLogContainer(() -> workout)
            .setExerciseContainer(() -> exercise)
            .setSets(List.of(3, 4, 6))
            .setWeight(30)
            .build());

    assertEquals(workout, entity.getLog());
    assertEquals(exercise, entity.getExercise());
    assertRepsMatch(sets, entity.getSets());
    assertEquals(30, entity.getWeight());
  }

  @Test
  @Disabled("Update request not yet implemented")
  void shouldMutateFromUpdateRequest() {
    var exercise = new ExerciseEntityImpl();
    var sets = List.of(3, 4, 6);
    var entity = new TrainedExerciseEntity()
        .mutateFrom(new CreateTrainedExerciseRepoRequestBuilder()
            .setExerciseContainer(() -> exercise)
            .setSets(List.of(3, 4, 6))
            .setWeight(30)
            .build());

    assertEquals(exercise, entity.getExercise());
    assertRepsMatch(sets, entity.getSets());
    assertEquals(30, entity.getWeight());
  }


  private void assertRepsMatch(List<Integer> expected,
                               List<ExerciseSetEntity> actual) {
    if (expected.size() != actual.size()) {
      assertionFailure()
          .expected(expected)
          .actual(actual)
          .buildAndThrow();
    }
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expected.get(i), actual.get(i).getReps());
    }
  }
}