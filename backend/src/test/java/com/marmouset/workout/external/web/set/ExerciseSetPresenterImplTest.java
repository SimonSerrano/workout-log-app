package com.marmouset.workout.external.web.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marmouset.workout.app.domain.set.impl.ExerciseSetImpl;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import org.junit.jupiter.api.Test;

class ExerciseSetPresenterImplTest {


  @Test
  void shouldCreateMatchingResponse() {
    var presenter = new ExerciseSetPresenterImpl();
    assertEquals(new ExerciseSetResponse(8L, 13),
        presenter.present(new ExerciseSetImpl(8L, 13)));
  }
}