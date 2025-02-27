package com.marmouset.workout.app.workout.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.adapter.WorkoutLogController;
import com.marmouset.workout.app.workout.adapter.dto.WorkoutLogResponse;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.CreateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.DeleteWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.GetLogDetailsUseCase;
import com.marmouset.workout.app.workout.usecase.ListWorkoutLogsUseCase;
import com.marmouset.workout.app.workout.usecase.UpdateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkoutLogControllerImplTest {

  private WorkoutLogController controller;

  private CreateWorkoutLogUseCase createUseCase;
  private DeleteWorkoutLogUseCase deleteUseCase;
  private GetLogDetailsUseCase getUseCase;
  private ListWorkoutLogsUseCase listUseCase;
  private UpdateWorkoutLogUseCase updateUseCase;

  @BeforeEach
  void setUp() {
    createUseCase = mock(CreateWorkoutLogUseCase.class);
    deleteUseCase = mock(DeleteWorkoutLogUseCase.class);
    getUseCase = mock(GetLogDetailsUseCase.class);
    listUseCase = mock(ListWorkoutLogsUseCase.class);
    updateUseCase = mock(UpdateWorkoutLogUseCase.class);
    controller = new WorkoutLogControllerImpl(
        createUseCase,
        deleteUseCase,
        getUseCase,
        listUseCase,
        updateUseCase);
  }

  @Test
  void shouldReturnCreatedWorkoutAsResponse() {
    var workout = new WorkoutLogTestDouble();
    var expected = new WorkoutLogResponse(
        workout.getId(),
        workout.getName(),
        workout.getCreatedAt().getEpochSecond());
    var command = new CreateWorkoutLogCommand(workout.getName());
    when(createUseCase.create(command)).thenReturn(workout);

    assertEquals(expected, controller.create(command));
  }

  @Test
  void shouldCallDelete() {
    var id = UUID.randomUUID();
    controller.delete(id);
    verify(deleteUseCase, times(1)).delete(id);
  }

  @Test
  void shouldReturnWorkoutLogAsResponse() throws WorkoutLogNotFoundException {
    var workout = new WorkoutLogTestDouble();
    var expected = new WorkoutLogResponse(
        workout.getId(),
        workout.getName(),
        workout.getCreatedAt().getEpochSecond());
    when(getUseCase.get(workout.getId())).thenReturn(workout);
    assertEquals(expected, controller.get(workout.getId()));
  }

  @Test
  void shouldReturnListOfWorkoutResponse() {
    var trainedList = List.of(
        new WorkoutLogTestDouble(),
        new WorkoutLogTestDouble());
    var expected = List.of(
        new WorkoutLogResponse(
            trainedList.get(0).getId(),
            trainedList.get(0).getName(),
            trainedList.get(0).getCreatedAt().getEpochSecond()),
        new WorkoutLogResponse(
            trainedList.get(1).getId(),
            trainedList.get(1).getName(),
            trainedList.get(1).getCreatedAt().getEpochSecond()));

    doReturn(trainedList).when(listUseCase).list();

    assertEquals(expected, controller.list());
  }

  @Test
  void shouldReturnUpdatedWorkout() throws WorkoutLogNotFoundException {
    var workout = new WorkoutLogTestDouble();
    var expected = new WorkoutLogResponse(
        workout.getId(),
        workout.getName(),
        workout.getCreatedAt().getEpochSecond());
    var command = new UpdateWorkoutLogCommand(
        workout.getId(),
        workout.getName());
    doReturn(workout).when(updateUseCase).update(command);

    assertEquals(expected, controller.update(command));
  }

}
