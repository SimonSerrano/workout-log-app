package com.marmouset.workout.app.exercise.external.spring.web;

import com.marmouset.workout.app.exercise.adapter.ExerciseController;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/exercise")
class ExerciseSpringController {

  private final ExerciseController controller;

  ExerciseSpringController(ExerciseController controller) {
    this.controller = controller;
  }

  /**
   * Get all the exercises available.
   *
   * @return a list of exercises
   */
  @GetMapping
  public ResponseEntity<Iterable<ExerciseResponse>> get() {
    return ResponseEntity.ok(controller.list());
  }
}
