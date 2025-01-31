package com.marmouset.workout.external.web.exercise;

import com.marmouset.workout.app.port.in.exercise.ListExercises;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
class ExerciseController {

  private final ListExercises listExercises;

  ExerciseController(ListExercises listExercises) {
    this.listExercises = listExercises;
  }

  @GetMapping
  public ResponseEntity<Iterable<ExerciseResponse>> get() {
    return ResponseEntity.ok(listExercises.list());
  }
}
