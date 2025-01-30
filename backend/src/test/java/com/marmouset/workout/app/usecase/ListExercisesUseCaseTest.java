package com.marmouset.workout.app.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.impl.ExerciseFactoryImpl;
import com.marmouset.workout.app.port.out.ExercisePresenter;
import com.marmouset.workout.app.port.out.ExerciseRepository;
import com.marmouset.workout.app.port.out.dto.ExerciseResponse;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ListExercisesUseCaseTest {

  @MockitoBean
  private ExerciseRepository repository;
  @MockitoBean
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
    var exercise1 = factory.create(UUID.randomUUID(), "Pull up");
    var exercise2 = factory.create(UUID.randomUUID(), "Push up");
    var expected1 = new ExerciseResponse(exercise1.id(), exercise1.name());
    var expected2 = new ExerciseResponse(exercise2.id(), exercise2.name());

    when(repository.getExercises()).thenReturn(List.of(
        exercise1,
        exercise2
    ));

    var result = useCase.listExercises().iterator();
    assertEquals(expected1, result.next());
    assertEquals(expected2, result.next());

  }

  @Test
  void shouldReturnEmpty() {
    when(repository.getExercises()).thenReturn(Collections.emptyList());

    assertEquals(0,
        StreamSupport.stream(useCase.listExercises().spliterator(), false)
            .toList().size());
  }
}