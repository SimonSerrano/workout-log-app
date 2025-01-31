package com.marmouset.workout.external.web.exercise.trained;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFound;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFound;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  TrainedExerciseController(
      ListTrainedExercises list,
      CreateTrainedExercise create) {
    this.listTrainedExercises = list;
    this.createTrainedExercise = create;
  }

  @GetMapping
  public ResponseEntity<Iterable<TrainedExerciseResponse>> getTrainedExercises(
      @PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(listTrainedExercises.list(logId));
    } catch (WorkoutLogNotFound e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping
  public ResponseEntity<TrainedExerciseResponse> createTrainedExercise(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateTrainedExerciseRequest request) {
    try {
      return new ResponseEntity<>(
          createTrainedExercise.create(
              new CreateTrainedExerciseCommand(logId, request.getExerciseId())),
          HttpStatus.CREATED);
    } catch (ExerciseNotFound e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
