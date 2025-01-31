package com.marmouset.workout.external.web.exercise;

import com.marmouset.workout.app.port.in.exercise.ListExercises;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

  private final ListExercises listExercisesPort;

  public ExerciseController(ListExercises listExercisesPort) {
    this.listExercisesPort = listExercisesPort;
  }

  @GetMapping
  public ResponseEntity<Iterable<ExerciseResponse>> getExercises() {
    return ResponseEntity.ok(listExercisesPort.list());
  }
}
