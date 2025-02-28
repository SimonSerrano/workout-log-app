package com.marmouset.workout.app.exercise.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.adapter.ExerciseRepositoryGateway;
import com.marmouset.workout.app.exercise.entity.ExerciseFactory;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.dto.CreateExerciseRepoRequest;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExerciseRepositoryImplTest {

  private ExerciseRepository repository;
  private ExerciseRepositoryGateway gatewayMock;
  private ExerciseFactory factoryMock;

  @BeforeEach
  void setUp() {
    gatewayMock = mock(ExerciseRepositoryGateway.class);
    factoryMock = mock(ExerciseFactory.class);
    repository = new ExerciseRepositoryImpl(gatewayMock, factoryMock);
  }

  @Test
  void shouldReturnListFromGateway() {
    var expected = List.of(
        new ExerciseTestDouble(),
        new ExerciseTestDouble());
    doReturn(expected).when(gatewayMock).findAll();

    assertEquals(expected, repository.read());
  }

  @Test
  void shouldReturnReferenceFromGateway() throws NotFoundException {
    var expected = new ExerciseTestDouble();
    doReturn(expected).when(gatewayMock).getReferenceById(expected.getName());
    assertEquals(expected, repository.readReference(expected.getName()));
  }

  @Test
  void shouldThrowNotFoundWhenGatewayThrows() {
    doThrow(EntityNotFoundException.class)
        .when(gatewayMock)
        .getReferenceById("Pull ups");
    assertThrows(NotFoundException.class,
        () -> repository.readReference("Pull ups"));
  }

  @Test
  void shouldCreateAnExerciseUsingTheFactory() {
    var expected = new ExerciseTestDouble();
    doReturn(expected).when(factoryMock).create(expected.getName());
    doReturn(expected).when(gatewayMock).save(expected);
    assertEquals(expected, repository.create(
        new CreateExerciseRepoRequest(expected.getName())));
  }

  @Test
  void shouldReturnExerciseFoundById() throws NotFoundException {
    var expected = new ExerciseTestDouble();
    doReturn(Optional.of(expected))
        .when(gatewayMock).findById(expected.getId());
    assertEquals(expected, repository.read(expected.getId()));
  }

  @Test
  void shouldThrowNotFoundIfExerciseIsNotFoundByItsId() {
    var id = "Pull ups";
    doReturn(Optional.empty()).when(gatewayMock).findById(id);
    assertThrows(NotFoundException.class, () -> repository.read(id));
  }

}