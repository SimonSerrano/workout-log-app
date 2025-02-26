package com.marmouset.workout.app.workout.external.spring.web;

import com.marmouset.workout.app.workout.adapter.WorkoutLogController;
import com.marmouset.workout.app.workout.adapter.dto.WorkoutLogResponse;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
class WorkoutLogSpringController {
  private final WorkoutLogController controller;

  WorkoutLogSpringController(WorkoutLogController controller) {
    this.controller = controller;
  }


  @GetMapping
  public ResponseEntity<Iterable<WorkoutLogResponse>> get() {
    return ResponseEntity.ok(controller.list());
  }


  @GetMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLogResponse> getById(@PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(controller.get(logId));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<WorkoutLogResponse> post(
      @Valid @RequestBody CreateOrUpdateWorkoutLogBody body) {
    return new ResponseEntity<>(
        controller.create(new CreateWorkoutLogCommand(body.getName())),
        HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{logId}")
  public ResponseEntity<Void> delete(@PathVariable UUID logId) {
    controller.delete(logId);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLogResponse> patch(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateOrUpdateWorkoutLogBody body) {
    try {
      var response = controller
          .update(new UpdateWorkoutLogCommand(logId, body.getName()));
      return ResponseEntity.ok(response);
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
