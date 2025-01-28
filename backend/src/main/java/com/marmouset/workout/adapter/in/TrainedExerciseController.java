package com.marmouset.workout.adapter.in;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmouset.workout.adapter.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.adapter.in.dto.CreateTrainedExerciseRequest;
import com.marmouset.workout.app.port.in.CreateTrainedExercisePort;
import com.marmouset.workout.app.port.in.ListTrainedExercisesPort;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/log/{logId}/trained")
public class TrainedExerciseController {

  private final ListTrainedExercisesPort listTrainedExercisesPort;
  private final CreateTrainedExercisePort createTrainedExercisePort;

  public TrainedExerciseController(ListTrainedExercisesPort listTrainedExercisesPort,
      CreateTrainedExercisePort createTrainedExercisePort) {
    this.listTrainedExercisesPort = listTrainedExercisesPort;
    this.createTrainedExercisePort = createTrainedExercisePort;
  }

  @GetMapping
  public ResponseEntity<Iterable<TrainedExercise>> getTrainedExercises(@PathVariable UUID logId) {
    return ResponseEntity.ok(listTrainedExercisesPort.listTrainedExercises(logId));
  }

  @PostMapping
  public ResponseEntity<TrainedExercise> createTrainedExercise(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateTrainedExerciseRequest request) {
    return new ResponseEntity<TrainedExercise>(
        createTrainedExercisePort.create(new CreateTrainedExerciseCommand(logId, request.getExerciseId())),
        HttpStatus.CREATED);
  }
}
