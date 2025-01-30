package com.marmouset.workout.external.web.exercise.trained;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmouset.workout.app.port.in.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.ListTrainedExercises;
import com.marmouset.workout.app.port.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/log/{logId}/trained")
public class TrainedExerciseController {

  private final ListTrainedExercises listTrainedExercises;
  private final CreateTrainedExercise createTrainedExercise;

  public TrainedExerciseController(
      ListTrainedExercises list,
      CreateTrainedExercise create) {
    this.listTrainedExercises = list;
    this.createTrainedExercise = create;
  }

  @GetMapping
  public ResponseEntity<Iterable<TrainedExerciseResponse>> getTrainedExercises(@PathVariable UUID logId) {
    return ResponseEntity.ok(listTrainedExercises.list(logId));
  }

  @PostMapping
  public ResponseEntity<TrainedExerciseResponse> createTrainedExercise(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateTrainedExerciseRequest request) {
    return new ResponseEntity<TrainedExerciseResponse>(
        createTrainedExercise.create(new CreateTrainedExerciseCommand(logId, request.getExerciseId())),
        HttpStatus.CREATED);
  }
}
