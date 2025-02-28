package com.marmouset.workout.app.progression.external.spring.web;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.adapter.ProgressionController;
import com.marmouset.workout.app.progression.adapter.RepsProgressionChartResponse;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise/{exerciseId}/progression")
class ProgressionSpringController {

  private final ProgressionController controller;

  public ProgressionSpringController(ProgressionController controller) {
    this.controller = controller;
  }

  @GetMapping
  public ResponseEntity<RepsProgressionChartResponse> get(
      @PathVariable String exerciseId) {
    try {
      return ResponseEntity.ok(controller.calculateRepsProgressionChart(
          new CalculateRepsProgressionChartCommand(exerciseId)));
    } catch (ExerciseNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

}
