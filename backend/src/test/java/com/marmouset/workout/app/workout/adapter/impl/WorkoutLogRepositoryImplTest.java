package com.marmouset.workout.app.workout.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.adapter.WorkoutLogRepositoryGateway;
import com.marmouset.workout.app.workout.entity.WorkoutLogFactory;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogRepoRequest;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkoutLogRepositoryImplTest {

  private WorkoutLogRepository repository;
  private WorkoutLogRepositoryGateway gatewayMock;
  private WorkoutLogFactory factoryMock;

  @BeforeEach
  void setUp() {
    gatewayMock = mock(WorkoutLogRepositoryGateway.class);
    factoryMock = mock(WorkoutLogFactory.class);
    repository = new WorkoutLogRepositoryImpl(
        gatewayMock,
        factoryMock);
  }

  @Test
  void shouldReturnListOfWorkoutLogs() {
    var expected = List.of(
        new WorkoutLogTestDouble(),
        new WorkoutLogTestDouble());
    doReturn(expected).when(gatewayMock).findAllByOrderByCreatedAtDesc();
    assertEquals(expected, repository.read());
  }

  @Test
  void shouldReturnWorkoutLog() throws NotFoundException {
    var expected = new WorkoutLogTestDouble();
    doReturn(Optional.of(expected))
        .when(gatewayMock).findById(expected.getId());
    assertEquals(expected, repository.read(expected.getId()));
  }

  @Test
  void shouldThrowNotFoundException() {
    var id = UUID.randomUUID();
    doReturn(Optional.empty()).when(gatewayMock).findById(id);
    assertThrows(
        NotFoundException.class,
        () -> repository.read(id));
  }

  @Test
  void shouldCreateWorkoutLog() {
    var expected = new WorkoutLogTestDouble();
    doReturn(expected).when(factoryMock).create(expected.getName());
    doReturn(expected).when(gatewayMock).save(expected);
    var request = new CreateWorkoutLogRepoRequest(expected.getName());
    assertEquals(expected, repository.create(request));
  }

  @Test
  void shouldCallDelete() {
    var id = UUID.randomUUID();
    repository.delete(id);
    verify(gatewayMock, times(1)).deleteById(id);
  }

  @Test
  void shouldReturnWorkoutLogReference() throws NotFoundException {
    var expected = new WorkoutLogTestDouble();
    doReturn(expected).when(gatewayMock).getReferenceById(expected.getId());

    assertEquals(expected, repository.readReference(expected.getId()));
  }

  @Test
  void shouldThrowNotFoundExceptionWhenReferenceNotFound() {
    var id = UUID.randomUUID();
    doThrow(EntityNotFoundException.class)
        .when(gatewayMock).getReferenceById(id);

    assertThrows(
        NotFoundException.class,
        () -> repository.readReference(id));
  }

  @Test
  void shouldReturnUpdatedWorkoutLog() throws NotFoundException {
    var expected = new WorkoutLogTestDouble();
    doReturn(Optional.of(expected))
        .when(gatewayMock).findById(expected.getId());
    doReturn(expected).when(gatewayMock).save(expected);
    var request = new UpdateWorkoutLogRepoRequest(expected.getId(), "Toto");

    assertEquals(expected, repository.update(request));

  }

  @Test
  void shouldThrowNotFoundExceptionWhenLogToUpdateIsNotFound() {
    var id = UUID.randomUUID();
    doReturn(Optional.empty())
        .when(gatewayMock).findById(id);
    var request = new UpdateWorkoutLogRepoRequest(id, "Toto");
    assertThrows(
        NotFoundException.class,
        () -> repository.update(request));

  }

  @Test
  void shouldReturnGatewayResultWhenExistsIsChecked() {
    var id = UUID.randomUUID();
    doReturn(true).when(gatewayMock).existsById(id);
    assertTrue(repository.exists(id));
  }

}
