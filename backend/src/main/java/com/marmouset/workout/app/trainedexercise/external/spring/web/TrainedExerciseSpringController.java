package com.marmouset.workout.app.trainedexercise.external.spring.web;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseController;
import com.marmouset.workout.app.trainedexercise.adapter.dto.TrainedExerciseResponse;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
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
class TrainedExerciseSpringController {

  private final TrainedExerciseController controller;


  TrainedExerciseSpringController(TrainedExerciseController controller) {
    this.controller = controller;
  }

  @GetMapping
  public ResponseEntity<Iterable<TrainedExerciseResponse>> get(
      @PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(controller.list(logId));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping(path = "/{trainedId}")
  public ResponseEntity<Void> delete(
      @PathVariable("logId") UUID logId,
      @PathVariable("trainedId") Long trainedId) {
    try {
      controller.delete(logId, trainedId);
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
          controller.create(commandBuilder.build()),
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
          .ok(controller.update(commandBuilder.build()));
    } catch (ExerciseNotFoundException | WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
