package com.marmouset.workout.app.exerciseset.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.exerciseset.ExerciseSetTestDouble;
import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import org.junit.jupiter.api.Test;

class ExerciseSetResponsePresenterImplTest {


  @Test
  void shouldCreateMatchingResponse() {
    var exSet = new ExerciseSetTestDouble();
    var presenter = new ExerciseSetResponsePresenterImpl();
    assertEquals(new ExerciseSetResponse(exSet.getId(), exSet.getReps()),
        presenter.present(exSet));
  }
}