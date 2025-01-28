package com.marmouset.workout.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmouset.workout.app.port.in.ListExercisesPort;
import com.marmouset.workout.domain.exercise.Exercise;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

  private final ListExercisesPort listExercisesPort;

  public ExerciseController(ListExercisesPort listExercisesPort) {
    this.listExercisesPort = listExercisesPort;
  }

  @GetMapping
  public ResponseEntity<Iterable<Exercise>> getExercises() {
    return ResponseEntity.ok(listExercisesPort.listExercises());
  }
}
