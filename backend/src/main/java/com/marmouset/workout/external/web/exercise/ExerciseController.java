package com.marmouset.workout.external.web.exercise;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmouset.workout.app.port.in.ListExercises;
import com.marmouset.workout.app.port.out.dto.ExerciseResponse;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

  private final ListExercises listExercisesPort;

  public ExerciseController(ListExercises listExercisesPort) {
    this.listExercisesPort = listExercisesPort;
  }

  @GetMapping
  public ResponseEntity<Iterable<ExerciseResponse>> getExercises() {
    return ResponseEntity.ok(listExercisesPort.listExercises());
  }
}
