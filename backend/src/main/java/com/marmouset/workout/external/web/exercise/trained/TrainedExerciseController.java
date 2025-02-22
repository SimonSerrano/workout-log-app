package com.marmouset.workout.external.web.exercise.trained;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.in.exercise.UpdateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.UpdatedTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/log/{logId}/trained")
class TrainedExerciseController {

  private final ListTrainedExercises listTrainedExercises;
  private final CreateTrainedExercise createTrainedExercise;
  private final DeleteTrainedExercise deleteTrainedExercise;

  private final UpdateTrainedExercise updateTrainedExercise;

  TrainedExerciseController(
      ListTrainedExercises list,
      CreateTrainedExercise create,
      DeleteTrainedExercise deleteTrainedExercise,
      UpdateTrainedExercise updateTrainedExercise) {
    this.listTrainedExercises = list;
    this.createTrainedExercise = create;
    this.deleteTrainedExercise = deleteTrainedExercise;
    this.updateTrainedExercise = updateTrainedExercise;
  }

  @GetMapping
  public ResponseEntity<Iterable<TrainedExerciseResponse>> get(
      @PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(listTrainedExercises.list(logId));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping(path = "/{trainedId}")
  public ResponseEntity<Void> delete(
      @PathVariable("logId") UUID logId,
      @PathVariable("trainedId") Long trainedId) {
    try {
      deleteTrainedExercise.delete(logId, trainedId);
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<TrainedExerciseResponse> post(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateOrUpdateTrainedExerciseBody body) {
    try {
      var commandBuilder = new CreateTrainedExerciseCommandBuilder()
          .setExerciseId(body.getExerciseId())
          .setLogId(logId);
      body.getSets().ifPresent(commandBuilder::setSets);
      body.getWeight().ifPresent(commandBuilder::setWeight);
      return new ResponseEntity<>(
          createTrainedExercise.create(commandBuilder.build()),
          HttpStatus.CREATED);
    } catch (ExerciseNotFoundException | WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PatchMapping(path = "/{trainedId}")
  public ResponseEntity<TrainedExerciseResponse> patch(
      @PathVariable("logId") UUID logId,
      @PathVariable("trainedId") Long trainedId,
      @Valid @RequestBody CreateOrUpdateTrainedExerciseBody body) {
    try {
      var commandBuilder = new UpdatedTrainedExerciseCommandBuilder()
          .setLogId(logId)
          .setTrainedId(trainedId)
          .setExerciseId(body.getExerciseId());
      body.getSets().ifPresent(commandBuilder::setSets);
      body.getWeight().ifPresent(commandBuilder::setWeight);
      return ResponseEntity
          .ok(updateTrainedExercise.update(commandBuilder.build()));
    } catch (ExerciseNotFoundException | WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
