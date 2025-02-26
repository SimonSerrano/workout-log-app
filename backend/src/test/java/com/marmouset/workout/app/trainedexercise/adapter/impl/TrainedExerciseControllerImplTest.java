package com.marmouset.workout.app.trainedexercise.adapter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.trainedexercise.TrainedExerciseTestDouble;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseController;
import com.marmouset.workout.app.trainedexercise.adapter.dto.TrainedExerciseResponse;
import com.marmouset.workout.app.trainedexercise.usecase.CreateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.DeleteTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.ListTrainedExercisesUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.UpdateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainedExerciseControllerImplTest {

  private TrainedExerciseController controller;
  private CreateTrainedExerciseUseCase createMock;
  private DeleteTrainedExerciseUseCase deleteMock;
  private ListTrainedExercisesUseCase listMock;
  private UpdateTrainedExerciseUseCase updateMock;

  private static TrainedExerciseResponse createTrainedExerciseResponse(
      TrainedExerciseTestDouble trained) {
    return new TrainedExerciseResponse(
        trained.getId(),
        trained.getLogId(),
        new ExerciseResponse(trained.getExercise().getName()),
        trained.getSets()
            .stream().map(set ->
                new ExerciseSetResponse(set.getId(), set.getReps())).toList(),
        trained.getWeight().orElse(null)
    );
  }

  @BeforeEach
  void setUp() {
    createMock = mock(CreateTrainedExerciseUseCase.class);
    deleteMock = mock(DeleteTrainedExerciseUseCase.class);
    listMock = mock(ListTrainedExercisesUseCase.class);
    updateMock = mock(UpdateTrainedExerciseUseCase.class);
    controller = new TrainedExerciseControllerImpl(
        createMock,
        deleteMock,
        listMock,
        updateMock
    );
  }

  @Test
  void shouldReturnCreatedTrainedExerciseAsResponse()
      throws WorkoutLogNotFoundException, ExerciseNotFoundException {
    var trained = new TrainedExerciseTestDouble();
    var expected = createTrainedExerciseResponse(trained);
    var command = new CreateTrainedExerciseCommand(
        trained.getLogId(),
        trained.getExercise().getId(),
        trained.getSets().stream().map(ExerciseSet::getReps).toList(),
        trained.getWeight().orElse(null));
    doReturn(trained).when(createMock).create(command);

    assertEquals(expected, controller.create(command));
  }

  @Test
  void shouldCallDeleteUseCase() throws WorkoutLogNotFoundException {
    var uuid = UUID.randomUUID();
    var id = new Random().nextLong();
    controller.delete(uuid, id);
    verify(deleteMock, times(1)).delete(uuid, id);
  }


  @Test
  void shouldReturnTrainedExercisesListAsResponse()
      throws WorkoutLogNotFoundException {
    var trainedList = List.of(
        new TrainedExerciseTestDouble(),
        new TrainedExerciseTestDouble()
    );
    var expected = List.of(
        createTrainedExerciseResponse(trainedList.get(0)),
        createTrainedExerciseResponse(trainedList.get(1))
    );

    doReturn(trainedList).when(listMock).list(trainedList.get(0).getLogId());

    assertEquals(expected, controller.list(trainedList.get(0).getLogId()));
  }

  @Test
  void shouldReturnUpdatedTrainedExerciseAsResponse()
      throws WorkoutLogNotFoundException, ExerciseNotFoundException {
    var trained = new TrainedExerciseTestDouble();
    var expected = createTrainedExerciseResponse(trained);
    var command = new UpdatedTrainedExerciseCommand(
        trained.getId(),
        trained.getLogId(),
        trained.getExercise().getId(),
        trained.getSets().stream().map(ExerciseSet::getReps).toList(),
        trained.getWeight().orElse(null)
    );
    doReturn(trained).when(updateMock).update(command);

    assertEquals(expected, controller.update(command));
  }
}