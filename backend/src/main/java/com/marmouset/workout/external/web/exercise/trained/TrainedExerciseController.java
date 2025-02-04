package com.marmouset.workout.external.web.exercise.trained;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  private final DeleteTrainedExercise deleteTrainedExercise;

  TrainedExerciseController(
      ListTrainedExercises list,
      CreateTrainedExercise create,
      DeleteTrainedExercise deleteTrainedExercise) {
    this.listTrainedExercises = list;
    this.createTrainedExercise = create;
    this.deleteTrainedExercise = deleteTrainedExercise;
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

  @PostMapping
  public ResponseEntity<TrainedExerciseResponse> post(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateOrUpdateTrainedExerciseBody body) {
    try {
      return new ResponseEntity<>(
          createTrainedExercise.create(
              new CreateTrainedExerciseCommand(logId, body.getExerciseId())),
          HttpStatus.CREATED);
    } catch (ExerciseNotFoundException | WorkoutLogNotFoundException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping(path = "/{trainedId}")
  public ResponseEntity<Void> delete(@PathVariable("logId") UUID logId,
                                     @PathVariable("trainedId")
                                     Long trainedId) {
    deleteTrainedExercise.delete(logId, trainedId);
    return ResponseEntity.noContent().build();
  }
}
