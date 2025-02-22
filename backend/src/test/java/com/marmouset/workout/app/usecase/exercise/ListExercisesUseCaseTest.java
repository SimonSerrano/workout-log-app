package com.marmouset.workout.app.usecase.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.impl.ExerciseFactoryImpl;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ListExercisesUseCaseTest {

  @MockitoBean
  private ExerciseRepository repository;
  @Autowired
  private ExercisePresenter presenter;

  private ListExercisesUseCase useCase;

  private ExerciseFactory factory;

  @BeforeEach
  void setUp() {
    useCase = new ListExercisesUseCase(repository, presenter);
    factory = new ExerciseFactoryImpl();
  }

  @Test
  void shouldReturnListOfExercises() {
    var exercise1 = factory.create("Pull up");
    var exercise2 = factory.create("Push up");
    var expected1 =
        new ExerciseResponse(exercise1.name());
    var expected2 =
        new ExerciseResponse(exercise2.name());

    when(repository.read()).thenReturn(List.of(
        exercise1,
        exercise2
    ));

    var result = useCase.list().iterator();
    assertEquals(expected1, result.next());
    assertEquals(expected2, result.next());

  }

  @Test
  void shouldReturnEmpty() {
    when(repository.read()).thenReturn(Collections.emptyList());
    assertTrue(useCase.list().isEmpty());
  }
}